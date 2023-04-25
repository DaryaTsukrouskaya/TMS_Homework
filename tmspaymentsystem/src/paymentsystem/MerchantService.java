package paymentsystem;

import paymentsystem.exceptions.BankAccountNotAddedException;
import paymentsystem.exceptions.BankAccountNotDeletedException;
import paymentsystem.exceptions.MerchantNotDeletedException;
import paymentsystem.exceptions.MerchantNotFoundException;
import paymentsystem.exceptions.NoBankAccountsFoundException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.nio.file.Files.createFile;

public class MerchantService implements FilesPathes {
    private static boolean exist = false;
    private List<Merchant> merchants;
    private static Path bankAccountsFile;
    private static Path merchantsFile;

    static {
        try {
            bankAccountsFile = createFile(Paths.get(BANK_ACCOUNTS));
            merchantsFile = createFile(Paths.get(MERCHANTS));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public MerchantService(List<Merchant> merchants) {
        this.merchants = merchants;
    }

    public void setMerchants(List<Merchant> merchants) {
        this.merchants = merchants;
    }

    public void addBankAccount(Merchant merchant, BankAccount bankAccount) throws BankAccountNotAddedException {
        boolean incorrectBankAccountNumber = Stream.of(bankAccount).anyMatch(c -> bankAccount.getAccountNumber().length() != 8 && bankAccount.getAccountNumber().matches("^[^0-9]*$"));
        if (incorrectBankAccountNumber) {
            throw new BankAccountNotAddedException("The length of account number should be eight digits without other characters!");
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

    public List<BankAccount> getMerchantBankAccounts(Merchant merchant) throws NoBankAccountsFoundException {
        if (merchant.getBankAccounts().isEmpty()) {
            throw new NoBankAccountsFoundException("This merchant does not have bank accounts");
        }
        List<BankAccount> merchantBankAccounts = merchant.getBankAccounts().stream().sorted(Comparator.comparing(BankAccount::getCreatedAt).thenComparing(BankAccount::getStatus)).toList();
        return merchantBankAccounts;
    }

    public void updateBankAccount(BankAccount bankAccount, String newAccountNum) throws NoBankAccountsFoundException {
        merchants.forEach(merchant -> {
            BankAccount foundBA = merchant.getBankAccounts().stream().filter(a -> a.getAccountNumber().equals(bankAccount.getAccountNumber())).findFirst().orElse(null);
            if (foundBA != null) {
                foundBA.setAccountNumber(newAccountNum);
                exist = true;
            }
        });
        if (!exist) {
            throw new NoBankAccountsFoundException("Its impossible to update non-existent account");
        } else {
            exist = false;
            try {
                List<String> linesOfFile = Files.readAllLines(Paths.get(BANK_ACCOUNTS));
                List<String> changedLinesOfFile = new ArrayList<>();
                for (String s : linesOfFile) {
                    if (s.contains(bankAccount.getAccountNumber())) {
                        String newS = s.replace(bankAccount.getAccountNumber(), newAccountNum);
                        changedLinesOfFile.add(newS);
                    } else {
                        changedLinesOfFile.add(s);
                    }
                }
                Files.delete(bankAccountsFile);
                Path newFile = Files.createFile(Paths.get(BANK_ACCOUNTS));
                Files.write(newFile, changedLinesOfFile);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean deleteBankAccount(BankAccount bankAccount) throws BankAccountNotDeletedException {
        Merchant merchant = merchants.stream().filter(c -> c.getId().equals(bankAccount.getMerchantId())).findFirst().get();
        boolean deleted = merchant.getBankAccounts().remove(bankAccount);
        try {
            List<String> linesOfFile = Files.readAllLines(Paths.get(BANK_ACCOUNTS));
            List<String> newLinesOfFile = linesOfFile.stream().filter(line -> !line.contains(bankAccount.getAccountNumber())).toList();
            Files.delete(bankAccountsFile);
            Path newFile = Files.createFile(Paths.get(BANK_ACCOUNTS));
            Files.write(newFile, newLinesOfFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if (!deleted) {
            throw new BankAccountNotDeletedException("Bank account not deleted");
        }
        return deleted;
    }

    public void createMerchant(Merchant merchant) {
        merchants.add(merchant);
        try {
            Files.write(merchantsFile, (merchant.getId() + " " + merchant.getName() + " " + " " + merchant.getCreatedAt() + "\n").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Merchant> getMerchants() {
        return merchants;
    }

    public Merchant getMerchantById(String id) throws MerchantNotFoundException {
        Merchant merchant = merchants.stream().filter(c -> c.getId().toString().equals(id)).findFirst().orElse(null);
        if (merchant == null) {
            throw new MerchantNotFoundException("Merchant not found");
        }
        return merchant;
    }

    public boolean deleteMerchant(String id) throws MerchantNotDeletedException, MerchantNotFoundException {
        Merchant merchant = merchants.stream().filter(c -> c.getId().toString().equals(id)).findFirst().orElse(null);
        if (merchant == null) {
            throw new MerchantNotFoundException("Merchant not found");
        }
        boolean deleted = merchants.remove(merchant);
        try {
            List<String> linesOfFileBankAcc = Files.readAllLines(Paths.get(BANK_ACCOUNTS));
            List<String> linesOfMerFile = Files.readAllLines(Paths.get(MERCHANTS));
            List<String> newLinesOfFileBankAcc = linesOfFileBankAcc.stream().filter(line -> !line.contains(id)).toList();
            List<String> newLinesOfMerFile = linesOfMerFile.stream().filter(line -> !line.contains(id)).toList();
            Files.delete(bankAccountsFile);
            Files.delete(merchantsFile);
            Path newFile1 = Files.createFile(Paths.get(BANK_ACCOUNTS));
            Path newFile2 = Files.createFile(Paths.get(MERCHANTS));
            Files.write(newFile1, newLinesOfFileBankAcc);
            Files.write(newFile2, newLinesOfMerFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        if (!deleted) {
            throw new MerchantNotDeletedException("Merchant not deleted!");
        }
        return deleted;
    }
}
