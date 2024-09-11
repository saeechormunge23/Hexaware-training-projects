package dao;

import model.Product;

public interface ProductDaoInterface {

    boolean addProduct(Product product);

    boolean removeProduct(int pid);

    boolean updatePrice(int pid, double newPrice);

    double calculateBill(int pid, int quantity);
}
