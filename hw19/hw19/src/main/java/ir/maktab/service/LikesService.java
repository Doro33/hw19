package ir.maktab.service;

import ir.maktab.base.service.BaseService;
import ir.maktab.entity.Likes;
import ir.maktab.entity.Tweet;

import java.util.Set;

public interface LikesService extends BaseService<Likes,Integer> {
    Likes likeATweet(Likes likes);

    void dislikeATweet(Likes likes);

    Long countATweetLikes(Tweet tweet);

    Set<String> whoLikedTheTweet(Tweet tweet);

}