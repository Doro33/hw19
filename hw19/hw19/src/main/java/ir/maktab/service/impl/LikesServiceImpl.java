package ir.maktab.service.impl;

import ir.maktab.base.service.impl.BaseServiceImpl;
import ir.maktab.dao.LikesDao;
import ir.maktab.entity.Likes;
import ir.maktab.entity.Tweet;
import ir.maktab.service.LikesService;

import java.util.Set;

public class LikesServiceImpl extends BaseServiceImpl<Likes,Integer, LikesDao> implements LikesService {
    public LikesServiceImpl(LikesDao repository) {
        super(repository);
    }


    @Override
    public Likes likeATweet(Likes likes) {
        return save(likes);
    }

    @Override
    public void dislikeATweet(Likes likes) {
        delete(likeATweet(likes));
    }

    @Override
    public Long countATweetLikes(Tweet tweet) {
        return repository.countATweetLikes(tweet);
    }

    @Override
    public Set<String> whoLikedTheTweet(Tweet tweet) {
        return repository.whoLikedTheTweet(tweet);
    }

}