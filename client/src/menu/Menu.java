package menu;

import paymentsystem.BankAccount;
import paymentsystem.Status;
import paymentsystem.exceptions.BankAccountNotAddedException;

import paymentsystem.Merchant;
import paymentsystem.MerchantService;
import paymentsystem.exceptions.BankAccountNotDeletedException;
import paymentsystem.exceptions.MerchantNotDeletedException;
import paymentsystem.exceptions.MerchantNotFoundException;
import paymentsystem.exceptions.NoBankAccountsFoundException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        List<Merchant> merchants = new ArrayList<>();
        MerchantService merchantService = new MerchantService(merchants);
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter anything other than zero to get started.");
        int choice = scan.nextInt();
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
                    } catch (BankAccountNotAddedException e) {
                        System.out.println(e.getMessage());
                    }
                    merchantService.createMerchant(merchant);
                }
                case 2 -> {
                    System.out.println("Enter merchant id:");
                    String id = scan.next();
                    Merchant merchant = null;
                    List<BankAccount> bankAccounts = null;
                    try {
                        merchant = merchantService.getMerchantById(id);
                        bankAccounts = merchantService.getMerchantBankAccounts(merchant);
                    } catch (MerchantNotFoundException | NoBankAccountsFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    bankAccounts.forEach(System.out::println);
                }
                case 3 -> {
                    System.out.println("Enter merchant id:");
                    String id = scan.next();
                    System.out.println("Enter account number for updating:");
                    String accNum = scan.next();
                    System.out.println("Enter new required account number:");
                    String newAccNum = scan.next();
                    Merchant merchant = null;
                    try {
                        merchant = merchantService.getMerchantById(id);
                        BankAccount bankAccount = new BankAccount(merchant.getId(), Status.ACTIVE, accNum, LocalDateTime.now());
                        merchantService.updateBankAccount(bankAccount, newAccNum);
                    } catch (MerchantNotFoundException | NoBankAccountsFoundException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 4 -> {
                    System.out.println("Enter merchant id:");
                    String id = scan.next();
                    Merchant merchant = null;
                    try {
                        merchant = merchantService.getMerchantById(id);
                    } catch (MerchantNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println("Enter account number for deleting:");
                    String accNum = scan.next();

                    List<BankAccount> bankAccounts = null;
                    try {
                        bankAccounts = merchantService.getMerchantBankAccounts(merchant);
                    } catch (NoBankAccountsFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    BankAccount bankAccount = bankAccounts.stream().filter(a -> a.getAccountNumber().equals(accNum)).findFirst().get();
                    boolean deleted = false;
                    try {
                        deleted = merchantService.deleteBankAccount(bankAccount);
                        System.out.println("Bank account successfully deleted!");
                    } catch (BankAccountNotDeletedException e) {
                        System.out.println(e.getMessage());
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
                    Merchant merchant = null;
                    try {
                        merchant = merchantService.getMerchantById(id);
                    } catch (MerchantNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    System.out.println(merchant.toString());
                }
                case 8 -> {
                    System.out.println("Enter merchant id for deleting:");
                    String id = scan.next();
                    boolean deleted = false;
                    try {
                        deleted = merchantService.deleteMerchant(id);
                        System.out.println("Merchant successfully deleted!");
                    } catch (MerchantNotDeletedException | MerchantNotFoundException e) {
                        System.out.println(e.getMessage());
                    }

                }
                default -> throw new IllegalStateException("Unexpected value: " + choice);
            }
        }

    }
}