package ir.maktab.dao.impl;

import ir.maktab.base.dao.impl.BaseDaoImpl;
import ir.maktab.dao.TweetDao;
import ir.maktab.entity.Tweet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.Set;
import java.util.stream.Collectors;

public class TweetDaoImpl extends BaseDaoImpl<Tweet,Integer> implements TweetDao {
    public TweetDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Tweet> getEntityClass() {
        return Tweet.class;
    }

    @Override
    public Set<Tweet> showAllTweets() {
        /*TypedQuery<Tweet> query = entityManager
                .createQuery(" from Tweet t " +
                                "where t.tweet is null "
                        , Tweet.class);

        return query.getResultStream().collect(Collectors.toSet());*/

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Tweet> cr = cb.createQuery(Tweet.class);
        Root<Tweet> root = cr.from(Tweet.class);
        cr.select(root).where(cb.isNull(root.get("tweet")));
        TypedQuery<Tweet> query = entityManager.createQuery(cr);
        return query.getResultStream().collect(Collectors.toSet());
    }

    @Override
    public Set<Tweet> showATweetsComments(Tweet tweet) {
        TypedQuery<Tweet> query = entityManager
                .createQuery("from Tweet t " +
                                "where t.tweet.id = :id "
                        , Tweet.class);

        query.setParameter("id",tweet.getId());

        return query.getResultStream().collect(Collectors.toSet());
    }
}


