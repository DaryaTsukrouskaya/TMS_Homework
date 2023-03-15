package by.teachmeskills.homework.hw_10032023.shop;

import by.teachmeskills.homework.hw_10032023.exceptions.EmptyProductListException;
import by.teachmeskills.homework.hw_10032023.exceptions.EntityAlreadyExistsException;
import by.teachmeskills.homework.hw_10032023.exceptions.EntityNotFoundException;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop();
        Product product = null;
        Product[] test = new Product[50];
        Product pasta = new Product(1, 400, "pasta");
        Product kiki = new Product(2, 300, "kiki");
        Product carrot = new Product(3, 500, "carrot");
        try {
            shop.addProduct(pasta);
            shop.addProduct(kiki);
            shop.addProduct(carrot);
        } catch (EntityAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
        try {
            test = shop.getShopProducts();
        } catch (EmptyProductListException e) {
            System.out.println(e.getMessage());
        }

        for (int i = 0; i <= test.length - 1; i++) {
            if (test[i] != null && test[i + 1] != null) {
                if (test[i].getPrice() > test[i + 1].getPrice()) {
                    product = test[i + 1];
                    test[i + 1] = test[i];
                    test[i] = product;
                }
            }
            if (test[i] != null) {
                System.out.println(test[i].toString());
            }
        }
        try {
            shop.deleteProduct(2);
        } catch (EmptyProductListException | EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("--------------------------------------");
        for (int i = 0; i <= test.length - 1; i++) {
            if (test[i] != null) {
                System.out.println(test[i].toString());
            }
        }
        System.out.println("--------------------------------------");
        try {
            shop.changeProduct(3);
        } catch (EmptyProductListException | EntityNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("--------------------------------------");
        for (int i = 0; i <= test.length - 1; i++) {
            if (test[i] != null) {
                System.out.println(test[i].toString());
            }
        }
    }
}
