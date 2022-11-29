package ir.maktab.dao;

import ir.maktab.base.dao.BaseDao;
import ir.maktab.entity.Likes;
import ir.maktab.entity.Tweet;

import java.util.Set;

public interface LikesDao extends BaseDao<Likes,Integer> {
    Long countATweetLikes(Tweet tweet);

    Set<String> whoLikedTheTweet(Tweet tweet);
}