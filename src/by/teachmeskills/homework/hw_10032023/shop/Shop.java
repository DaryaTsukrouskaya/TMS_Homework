package by.teachmeskills.homework.hw_10032023.shop;

import by.teachmeskills.homework.hw_10032023.exceptions.EmptyProductListException;
import by.teachmeskills.homework.hw_10032023.exceptions.EntityAlreadyExistsException;
import by.teachmeskills.homework.hw_10032023.exceptions.EntityNotFoundException;

import java.util.Scanner;

public class Shop {
    private Product[] productList = new Product[50];
    private int goodsListIndex = 0;
    private Scanner scanner = new Scanner(System.in);

    public void addProduct(Product product) throws EntityAlreadyExistsException {
        boolean alreadyExists = false;
        for (int i = 0; i <= productList.length - 1; i++) {
            if (productList[i] != null && productList[i].getId() == product.getId()) {
                alreadyExists = true;
                break;
            }
        }
        if (alreadyExists) {
            throw new EntityAlreadyExistsException("The item with the specified number is already exists");
        } else {
            productList[goodsListIndex++] = product;
            System.out.println("The item is successfully added to she shop");
        }
    }

    public Product[] getShopProducts() throws EmptyProductListException {
        boolean emptyList = true;
        for (int i = 0; i <= productList.length - 1; i++) {
            if (productList[i] != null) {
                emptyList = false;
                break;
            }
        }
        if (emptyList) {
            throw new EmptyProductListException("No products found");
        }
        return productList;
    }

    public void deleteProduct(int productId) throws EmptyProductListException, EntityNotFoundException {
        boolean emptyList = true;
        boolean notFoundEntity = true;
        for (int i = 0; i <= productList.length - 1; i++) {
            if (productList[i] != null) {
                emptyList = false;
                break;
            }
        }
        if (emptyList) {
            throw new EmptyProductListException("No products found");
        } else {
            for (int i = 0; i < productList.length - 1; i++) {
                if (productList[i] != null) {
                    if (productList[i].getId() == productId) {
                        productList[i] = null;
                        notFoundEntity = false;
                        return;
                    }
                }
            }
            if (notFoundEntity) {
                throw new EntityNotFoundException("Product with " + productId + " not found");
            }
        }
    }

    public void changeProduct(int productId) throws EmptyProductListException, EntityNotFoundException {
        boolean emptyList = true;
        boolean notFoundEntity = true;
        for (int i = 0; i <= productList.length - 1; i++) {
            if (productList[i] != null) {
                emptyList = false;
                break;
            }
        }
        if (emptyList) {
            throw new EmptyProductListException("No products found");
        }
        for (int i = 0; i < productList.length - 1; i++) {
            if (productList[i] == null) {
                continue;
            }
            if (productList[i].getId() == productId) {
                System.out.println("Choose,what product parameter you would like to change: ");
                System.out.print("1 - name , 2 - price : ");
                int change = scanner.nextInt();
                switch (change) {
                    case 1:
                        System.out.print("Enter new name: ");
                        String newName = scanner.next();
                        productList[i].setName(newName);
                        break;
                    case 2:
                        System.out.println("Enter new price ");
                        int newPrice = scanner.nextInt();
                        productList[i].setPrice(newPrice);
                        break;
                    default:
                        System.out.println("There is no such option");
                        break;
                }
                notFoundEntity = false;
                return;
            }
        }
        if (notFoundEntity) {
            throw new EntityNotFoundException("Product with " + productId + " not found");
        }
    }
}


