package ir.maktab.service;

import ir.maktab.base.service.BaseService;
import ir.maktab.entity.Tweet;

import java.util.Set;

public interface TweetService extends BaseService<Tweet,Integer> {
    Set<Tweet> showAllTweets();

    Set<Tweet> showATweetsComments(Tweet tweet);

    void printATweetWithDetails(Tweet tweet);
}