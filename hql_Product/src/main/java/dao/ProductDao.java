package dao;

import model.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import connection.Connection;

public class ProductDao implements ProductDaoInterface {

    @Override
    public boolean addProduct(Product product) {
        Session session = Connection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            session.save(product);
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean removeProduct(int pid) {
        Session session = Connection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            String hqlFind = "FROM Product WHERE pid = :pid";
            Query<Product> queryFind = session.createQuery(hqlFind, Product.class);
            queryFind.setParameter("pid", pid);
            Product product = queryFind.uniqueResult();

            if (product != null) {
                session.delete(product);
                transaction.commit();
                return true;
            } else {
                transaction.rollback();
                return false;
            }
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public boolean updatePrice(int pid, double newPrice) {
        Session session = Connection.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            String hqlUpdate = "UPDATE Product SET price = :price WHERE pid = :pid";
            Query queryUpdate = session.createQuery(hqlUpdate);
            queryUpdate.setParameter("price", newPrice);
            queryUpdate.setParameter("pid", pid);
            int result = queryUpdate.executeUpdate();

            transaction.commit();
            return result > 0;
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public double calculateBill(int pid, int quantity) {
        Session session = Connection.getSessionFactory().openSession();

        try {
            String hqlFind = "FROM Product WHERE pid = :pid";
            Query<Product> queryFind = session.createQuery(hqlFind, Product.class);
            queryFind.setParameter("pid", pid);
            Product product = queryFind.uniqueResult();

            if (product != null) {
                return product.getPrice() * quantity;
            } else {
                return 0.0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        } finally {
            session.close();
        }
    }
}
