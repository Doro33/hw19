package ir.maktab.dao.impl;

import ir.maktab.base.dao.impl.BaseDaoImpl;
import ir.maktab.dao.FollowDao;
import ir.maktab.entity.Account;
import ir.maktab.entity.Follow;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FollowDaoImpl extends BaseDaoImpl<Follow,Integer> implements FollowDao {
    public FollowDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Follow> getEntityClass() {
        return null;
    }

    @Override
    public Set<String> showFollowers(Account account) {
        return entityManager
                .createQuery("select f.follower.username from Follow f " +
                                 "where f.following.id = :id", String.class)
                .setParameter("id", account.getId())
                .getResultStream()
                .collect(Collectors.toSet());

    }

    @Override
    public Set<String> showFollowing(Account account) {
        return entityManager
                .createQuery("select f.following.username from Follow f " +
                                "where f.follower.id = :id", String.class)
                .setParameter("id", account.getId())
                .getResultStream()
                .collect(Collectors.toSet());
    }
}