package com.example.wsdemo2.repository.user;

import com.example.wsdemo2.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class UserRepoImpl implements UserCustomRepo {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<User> getCustom(String userId) {
        Query query = entityManager.createNativeQuery("SELECT * FROM USER WHERE USER_ID = ?", User.class);
        query.setParameter(1, userId);
        return query.getResultList();
    }
}
