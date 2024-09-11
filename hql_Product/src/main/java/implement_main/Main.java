package implement_main;

import service.Service;
import dao.ProductDao;
import dao.ProductDaoInterface;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductDaoInterface productDao = new ProductDao();
        Service productService = new Service(productDao);

        while (true) {
            System.out.println("1. Add Product");
            System.out.println("2. Remove Product");
            System.out.println("3. Update Price");
            System.out.println("4. Calculate Bill");
            System.out.println("0. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    productService.addProduct();
                    break;

                case 2:
                    productService.removeProduct();
                    break;

                case 3:
                    productService.updatePrice();
                    break;

                case 4:
                    productService.calculateBill();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }
}
