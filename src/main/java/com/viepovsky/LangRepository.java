package com.viepovsky;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

class LangRepository {
    Optional<Lang> findById(Long id) {
        var session = HibernateUtil.getSessionFactory().openSession();
        var transaction = session.beginTransaction();
        var result = session.get(Lang.class, id);
        transaction.commit();
        session.close();
        return Optional.ofNullable(result);
    }
}