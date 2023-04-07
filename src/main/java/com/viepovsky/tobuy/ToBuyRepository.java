package com.viepovsky.tobuy;

import com.viepovsky.HibernateUtil;
import jakarta.persistence.Query;

import java.util.List;

public class ToBuyRepository {
    List<ToBuy> findAll() {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();

        var result = session.createQuery("from ToBuy", ToBuy.class).list();

        transaction.commit();
        session.close();
        return result;
    }
    ToBuy toggleToBuy(Long id) {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();

        var result = session.get(ToBuy.class, id);
        result.setBought(!result.isBought());

        transaction.commit();
        session.close();
        return result;
    }

    ToBuy addToBuy(ToBuy newToBuy) {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();

        session.persist(newToBuy);

        transaction.commit();
        session.close();
        return newToBuy;
    }

    void deleteAlToBuy() {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();

        Query query = session.createQuery("DELETE FROM ToBuy");
        query.executeUpdate();

        transaction.commit();
        session.close();
    }
}
