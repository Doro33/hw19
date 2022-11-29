package ir.maktab.service.impl;

import ir.maktab.base.service.impl.BaseServiceImpl;
import ir.maktab.dao.TweetDao;
import ir.maktab.entity.Tweet;
import ir.maktab.service.TweetService;
import ir.maktab.utils.AppContext;

import java.util.Set;

public class TweetServiceImpl extends BaseServiceImpl<Tweet,Integer, TweetDao> implements TweetService {
    public TweetServiceImpl(TweetDao repository) {
        super(repository);
    }

    @Override
    public Set<Tweet> showAllTweets() {
        return repository.showAllTweets();
    }

    @Override
    public Set<Tweet> showATweetsComments(Tweet tweet) {
        return repository.showATweetsComments(tweet);
    }

    @Override
    public void printATweetWithDetails(Tweet tweet) {
        Set<Tweet> comments = AppContext.getTWEET_SER().showATweetsComments(tweet);
        Set<String> likes = AppContext.getLIKES_SER().whoLikedTheTweet(tweet);
        System.out.println("Tweet(account=" + tweet.getAccount().getUsername()
                + ", text=" + tweet.getText()
                + ", createAt=" + tweet.getCreateAt()
                + ", likes=" + likes.size()
                + ", comments=" + comments.size()+ ")");
        System.out.println("***");
        System.out.println("liked by:");
        AppContext.setPrinter(likes);
        System.out.println("***");
        AppContext.setPrinter(comments);
    }
}