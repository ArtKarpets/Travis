package com.kart.springboot.dao;

import com.kart.springboot.model.Product;
import com.kart.springboot.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductDaoImpl implements ProductDao {

    @Override
    public Product addProduct(Product product) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(product);
        transaction.commit();
        session.close();
        return product;
    }

    @Override
    public void deleteProduct(Product product) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(product);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Product> getAllProduct() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Product> allProduct = session.createQuery("Select p FROM Product p", Product.class).getResultList();
        transaction.commit();
        session.close();
        return allProduct;
    }

    @Override
    public Product getProductById(Long id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Product product = session.byId(Product.class).load(id);
        transaction.commit();
        session.close();
        return product;
    }
}
