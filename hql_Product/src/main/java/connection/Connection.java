package connection;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import model.Product;

public class Connection {

    private static SessionFactory sessionFactory;

    private Connection() {
    	
    }

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            synchronized (Connection.class) {
                if (sessionFactory == null) {
                    try {
                        sessionFactory = new Configuration()
                                .configure("hibernate.cfg.xml")  
                                .addAnnotatedClass(Product.class)  
                                .buildSessionFactory();
                    } catch (Throwable ex) {
                        System.err.println("Initial SessionFactory creation failed." + ex);
                        throw new ExceptionInInitializerError(ex);
                    }
                }
            }
        }
        return sessionFactory;
    }
}
