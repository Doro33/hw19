package ir.maktab.dao.impl;

import ir.maktab.base.dao.impl.BaseDaoImpl;
import ir.maktab.dao.AccountDao;
import ir.maktab.entity.Account;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.Set;
import java.util.stream.Collectors;

public class AccountDaoImpl extends BaseDaoImpl<Account,Integer> implements AccountDao {
    public AccountDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Account> getEntityClass() {
        return Account.class;
    }

    @Override
    public Set<String> searchAccountByUsername(String input) {
        TypedQuery<String> query = entityManager
                .createQuery("select a.username from Account a " +
                                "where a.username like concat('%',:username,'%') "
                        , String.class);
        query.setParameter("username",input);
        return query.getResultStream().collect(Collectors.toSet());
    }
}