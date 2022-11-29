package ir.maktab.dao.impl;

import ir.maktab.base.dao.impl.BaseDaoImpl;
import ir.maktab.dao.LikesDao;
import ir.maktab.entity.Likes;
import ir.maktab.entity.Tweet;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.Set;
import java.util.stream.Collectors;

public class LikesDaoImpl extends BaseDaoImpl<Likes,Integer> implements LikesDao {
    public LikesDaoImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Likes> getEntityClass() {
        return Likes.class;
    }

    @Override
    public Long countATweetLikes(Tweet tweet) {
        TypedQuery<Long> query = entityManager
                .createQuery("select count(id) from Likes l where l.tweet.id = :tweetId ", Long.class);

        query.setParameter("tweetId",tweet.getId());

        return query.getSingleResult();

       /* CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> cr = cb.createQuery(Long.class);
        Root<Likes> root = cr.from(Likes.class);
        cr.select(cb.count(root.get("id")));

        TypedQuery<Long> query = entityManager.createQuery(cr);
        System.out.println(query.getResultList().size());
        return Long.valueOf(query.getResultList().size());*/
    }

    @Override
    public Set<String> whoLikedTheTweet(Tweet tweet) {
        TypedQuery<String> query = entityManager
                .createQuery("select l.account.username from Likes l " +
                                "where l.tweet.id = :id "
                        , String.class);

        query.setParameter("id",tweet.getId());

        return query.getResultStream().collect(Collectors.toSet());
    }
}