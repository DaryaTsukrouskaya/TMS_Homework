package paymentsystem;

import paymentsystem.exceptions.MerchantNotFoundException;
import paymentsystem.exceptions.NoBankAccountsFoundException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;
import java.nio.file.Path;

import static java.nio.file.Files.createFile;

public class MerchantService {
    private List<Merchant> Merchants;
    private static final String BANK_ACCOUNTS = "C:\\bank_account.txt";
    private static final String MERCHANTS = "C:\\merchant.txt";
    static Path bankAccountsFile;
    static Path merchantsFile;

    static {
        try {
            bankAccountsFile = createFile(Paths.get("C:\\bank_account.txt"));
            merchantsFile = createFile(Paths.get(MERCHANTS));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public MerchantService(List<Merchant> merchants) {
        this.Merchants = merchants;
    }

    public void setMerchants(List<Merchant> merchants) {
        Merchants = merchants;
    }

    public void addBankAccount(Merchant merchant, BankAccount bankAccount) throws IllegalArgumentException {
        boolean incorrectBankAccountNumber = Stream.of(bankAccount).anyMatch(c -> bankAccount.getAccountNumber().length() != 8 && bankAccount.getAccountNumber().matches("^[^0-9]*$"));
        if (incorrectBankAccountNumber) {
            throw new IllegalArgumentException("The length of account number should be eight digits without other characters!");
        }
        BankAccount existAccount = merchant.getBankAccounts().stream().filter
                (c -> c.getAccountNumber().equals(bankAccount.getAccountNumber())).findFirst().orElse(null);
        if (existAccount != null) {
            if (existAccount.getStatus() == Status.DELETED) {
                existAccount.setStatus(Status.ACTIVE);
            }
        } else {
            merchant.setBankAccount(bankAccount);
            try {
                Files.write(bankAccountsFile, (merchant.getId() + " " + bankAccount.getStatus() + " " + bankAccount.getAccountNumber() + " " + bankAccount.getCreatedAt() + "\n").getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<BankAccount> getMerchantBankAccounts(Merchant merchant) {
        if (merchant.getBankAccounts() == null) {
            try {
                throw new NoBankAccountsFoundException("This merchant does not have bank accounts");
            } catch (NoBankAccountsFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        List<BankAccount> merchantBankAccounts = merchant.getBankAccounts().stream().sorted(Comparator.comparing(BankAccount::getCreatedAt).thenComparing(BankAccount::getStatus)).toList();
        return merchantBankAccounts;
    }

    public void updateBankAccount(BankAccount bankAccount, String newAccountNum) {
        boolean exist = Merchants.stream().anyMatch(c -> c.getBankAccounts().stream().filter(a -> a.getAccountNumber().equals(newAccountNum)).isParallel());
        if (!exist) {
            try {
                throw new NoBankAccountsFoundException("Its impossible to update non-existent account");
            } catch (NoBankAccountsFoundException e) {
                System.out.println(e.getMessage());
            }
        } else {
            bankAccount.setAccountNumber(newAccountNum);
            try {
                List<String> linesOfFile = Files.readAllLines(Paths.get(BANK_ACCOUNTS));
                linesOfFile.stream().map(line -> line.replaceFirst(bankAccount.getAccountNumber(), newAccountNum)).toList();
                for (int i = 0; i < linesOfFile.size(); i++) {
                    Files.write(Paths.get(BANK_ACCOUNTS), (linesOfFile + "\n").getBytes());
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean deleteBankAccount(BankAccount bankAccount) {
        Merchant merchant = Merchants.stream().filter(c -> c.getId().equals(bankAccount.getMerchantId())).findFirst().get();
        boolean deleted = merchant.getBankAccounts().remove(bankAccount);
        try {
            List<String> linesOfFile = Files.readAllLines(Paths.get(BANK_ACCOUNTS));
            linesOfFile = linesOfFile.stream().filter(line -> !line.contains(bankAccount.getAccountNumber())).toList();
            for (int i = 0; i < linesOfFile.size(); i++) {
                Files.write(Paths.get(BANK_ACCOUNTS), (linesOfFile.get(i) + "\n").getBytes());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return deleted;
    }

    public void createMerchant(Merchant merchant) {
        Merchants.add(merchant);
        try {
            Files.write(merchantsFile, (merchant.getId() + " " + merchant.getName() + " " + " " + merchant.getCreatedAt() + "\n").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Merchant> getMerchants() {
        return Merchants;
    }

    public Merchant getMerchantById(String id) {
        Merchant merchant = Merchants.stream().filter(c -> c.getId().toString().equals(id)).findFirst().orElse(null);
        if (merchant == null) {
            try {
                throw new MerchantNotFoundException("Merchant not found");
            } catch (MerchantNotFoundException e) {
                System.out.println(e.getMessage());
            }
        }
        return merchant;
    }

    public boolean deleteMerchant(String id) {
        Merchant merchant = Merchants.stream().filter(c -> c.getId().toString().equals(id)).findFirst().orElse(null);
        boolean deleted = Merchants.remove(merchant);
        try {
            List<String> linesOfMerFile = Files.readAllLines(Paths.get(MERCHANTS));
            List<String> linesOfBAFile = Files.readAllLines(Paths.get(BANK_ACCOUNTS));
            linesOfMerFile = linesOfMerFile.stream().filter(line -> !line.contains(id)).toList();
            linesOfBAFile = linesOfBAFile.stream().filter(line -> !line.contains(id)).toList();
            for (int i = 0; i < linesOfMerFile.size(); i++) {
                Files.write(Paths.get(MERCHANTS), (linesOfMerFile.get(i) + "\n").getBytes());
            }
            for (int i = 0; i < linesOfBAFile.size(); i++) {
                Files.write(Paths.get(MERCHANTS), (linesOfBAFile.get(i) + "\n").getBytes());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return deleted;
    }
}
