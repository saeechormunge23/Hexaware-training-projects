package service;

import dao.ProductDaoInterface;
import model.Product;

import java.util.Scanner;

public class Service {

    private final ProductDaoInterface productDao;
    private final Scanner scanner = new Scanner(System.in);

    public Service(ProductDaoInterface productDao) {
        this.productDao = productDao;
    }

    public void addProduct() {
        System.out.print("Enter Product ID: ");
        int pid = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Product Price: ");
        double price = scanner.nextDouble();

        Product product = new Product(pid, name, price);
        if (productDao.addProduct(product)) {
            System.out.println("Product added successfully.");
        } else {
            System.out.println("Failed to add product.");
        }
    }

    public void removeProduct() {
        System.out.print("Enter Product ID to remove: ");
        int pid = scanner.nextInt();

        if (productDao.removeProduct(pid)) {
            System.out.println("Product removed successfully.");
        } else {
            System.out.println("Failed to remove product. Product ID may not exist.");
        }
    }

    public void updatePrice() {
        System.out.print("Enter Product ID: ");
        int pid = scanner.nextInt();
        System.out.print("Enter New Price: ");
        double newPrice = scanner.nextDouble();

        if (productDao.updatePrice(pid, newPrice)) {
            System.out.println("Price updated successfully.");
        } else {
            System.out.println("Failed to update price.");
        }
    }

    public void calculateBill() {
        System.out.print("Enter Product ID: ");
        int pid = scanner.nextInt();
        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();

        double bill = productDao.calculateBill(pid, quantity);
        if (bill > 0) {
            System.out.println("Total bill: " + bill);
        } else {
            System.out.println("Product not found or invalid quantity.");
        }
    }
}
