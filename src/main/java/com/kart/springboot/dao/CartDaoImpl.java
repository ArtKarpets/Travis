package com.kart.springboot.dao;

import com.kart.springboot.model.Cart;
import com.kart.springboot.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

@Service
public class CartDaoImpl implements CartDao {

    @Override
    public Cart addCart(Cart cart) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(cart);
        transaction.commit();
        session.close();
        return cart;
    }

    @Override
    public void updateCart(Cart cart) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(cart);
        transaction.commit();
        session.close();
    }

    @Override
    public Cart getCartById(Long id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Cart cart = session.byId(Cart.class).load(id);
        transaction.commit();
        session.close();
        return cart;
    }
}
