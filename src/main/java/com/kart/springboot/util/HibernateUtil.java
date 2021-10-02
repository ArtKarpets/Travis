package com.kart.springboot.util;

import com.kart.springboot.model.Cart;
import com.kart.springboot.model.Product;
import com.kart.springboot.model.User;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

@Slf4j
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {

                Configuration configuration = new Configuration().configure();

                configuration.addAnnotatedClass(Cart.class);
                configuration.addAnnotatedClass(User.class);
                configuration.addAnnotatedClass(Product.class);

                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                log.error(String.valueOf(e));
            }
        }
        return sessionFactory;
    }
}
