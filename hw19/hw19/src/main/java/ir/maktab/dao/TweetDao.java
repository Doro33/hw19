package ir.maktab.dao;

import ir.maktab.base.dao.BaseDao;
import ir.maktab.entity.Tweet;

import java.util.Set;

public interface TweetDao extends BaseDao<Tweet,Integer> {
    Set<Tweet> showAllTweets();

    Set<Tweet> showATweetsComments(Tweet tweet);

}