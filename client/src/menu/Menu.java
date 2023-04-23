package menu;

import paymentsystem.*;

import java.util.List;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        List<Merchant> merchants = new ArrayList<>();
        MerchantService merchantService = new MerchantService(merchants);
        int choice = 2;
        while (choice != 0) {
            System.out.println("Please enter the number corresponding to what you want to do:");
            System.out.println("""
                    1- to add bank account
                    2- to get merchant bank accounts
                    3- to update bank account
                    4- delete bank account
                    5- create merchant
                    6- get all merchants
                    7- get merchant by id
                    8- delete merchant
                    0- exit""");
            Scanner scan = new Scanner(System.in);
            choice = scan.nextInt();
            switch (choice) {
                case 0 -> {
                    return;
                }
                case 1 -> {
                    System.out.println("Enter merchant name:");
                    String name = scan.next();
                    System.out.println("Enter account number (8 numbers):");
                    String accNum = scan.next();
                    Merchant merchant = new Merchant(name, LocalDateTime.now());
                    BankAccount bankAccount = new BankAccount(merchant.getId(), Status.ACTIVE, accNum, LocalDateTime.now());
                    try {
                        merchantService.addBankAccount(merchant, bankAccount);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    merchantService.createMerchant(merchant);
                }
                case 2 -> {
                    System.out.println("Enter merchant id:");
                    String id = scan.next();
                    Merchant merchant = merchantService.getMerchantById(id);
                    List<BankAccount> bankAccounts = merchantService.getMerchantBankAccounts(merchant);
                    bankAccounts.forEach(System.out::println);
                }
                case 3 -> {
                    System.out.println("Enter merchant id:");
                    String id = scan.next();
                    System.out.println("Enter account number for updating:");
                    String accNum = scan.next();
                    System.out.println("Enter new required account number:");
                    String newAccNum = scan.next();
                    Merchant merchant = merchantService.getMerchantById(id);
                    List<BankAccount> bankAccounts = merchantService.getMerchantBankAccounts(merchant);
                    BankAccount bankAccount = bankAccounts.stream().filter(a -> a.getAccountNumber().equals(accNum)).findFirst().get();
                    merchantService.updateBankAccount(bankAccount, newAccNum);
                }
                case 4 -> {
                    System.out.println("Enter merchant id:");
                    String id = scan.next();
                    Merchant merchant = merchantService.getMerchantById(id);
                    System.out.println("Enter account number for deleting:");
                    String accNum = scan.next();
                    List<BankAccount> bankAccounts = merchantService.getMerchantBankAccounts(merchant);
                    BankAccount bankAccount = bankAccounts.stream().filter(a -> a.getAccountNumber().equals(accNum)).findFirst().get();
                    boolean deleted = merchantService.deleteBankAccount(bankAccount);
                    if (deleted) {
                        System.out.println("Bank account successfully deleted!");
                    } else {
                        System.out.println("Something went wrong...");
                    }
                }
                case 5 -> {
                    System.out.println("Enter merchant name:");
                    String name = scan.next();
                    Merchant merchant = new Merchant(name, LocalDateTime.now());
                    merchantService.createMerchant(merchant);
                }
                case 6 -> {
                    List<Merchant> merchantsList = merchantService.getMerchants();
                    merchantsList.forEach(System.out::println);
                }
                case 7 -> {
                    System.out.println("Enter merchant id:");
                    String id = scan.next();
                    Merchant merchant = merchantService.getMerchantById(id);
                    System.out.println(merchant.toString());
                }
                case 8 -> {
                    System.out.println("Enter merchant id for deleting:");
                    String id = scan.next();
                    boolean deleted = merchantService.deleteMerchant(id);
                    if (deleted) {
                        System.out.println("Merchant successfully deleted!");
                    } else {
                        System.out.println("Something went wrong...");
                    }
                }
                default -> throw new IllegalStateException("Unexpected value: " + choice);
            }
        }

    }
}