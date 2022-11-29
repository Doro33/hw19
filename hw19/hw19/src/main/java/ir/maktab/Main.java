package ir.maktab;

import ir.maktab.dao.AccountDao;
import ir.maktab.dao.impl.AccountDaoImpl;
import ir.maktab.entity.Account;
import ir.maktab.entity.Follow;
import ir.maktab.entity.Likes;
import ir.maktab.entity.Tweet;
import ir.maktab.service.AccountService;
import ir.maktab.service.impl.AccountServiceImpl;
import ir.maktab.utils.AppContext;


public class Main {
    public static void main(String[] args) {

        Account account0 = Account.builder()
                .username("sin")
                .password("33")
                .build();

        Account account1 = Account.builder()
                .username("ali")
                .password("11")
                .build();

        Account account2 = Account.builder()
                .username("farzad")
                .password("00")
                .build();

        Tweet tweet0 = Tweet.builder()
                .account(account0)
                .text("hi-0")
                .build();

        Tweet tweet1 = Tweet.builder()
                .account(account0)
                .text("hi-1")
                .build();

        Tweet comment0 = Tweet.builder()
                .account(account1)
                .tweet(tweet0)
                .text("morning").build();

        Tweet comment1 = Tweet.builder()
                .account(account2)
                .tweet(tweet0)
                .text("good afternoon").build();

        Tweet reply0 = Tweet.builder()
                .account(account0)
                .text("morning buddy")
                .tweet(comment0)
                .build();

        Likes likes0= Likes.builder()
                .account(account1)
                .tweet(tweet0)
                .build();

        Likes likes1= Likes.builder()
                .account(account2)
                .tweet(tweet0)
                .build();

        Follow follow0 = Follow.builder()
                .following(account0)
                .follower(account1).build();

        Follow follow1 = Follow.builder()
                .following(account0)
                .follower(account2).build();

        AppContext.getACCOUNT_SER().save(account0);
        AppContext.getACCOUNT_SER().save(account1);
        AppContext.getACCOUNT_SER().save(account2);

        AppContext.getTWEET_SER().save(tweet0);
        AppContext.getTWEET_SER().save(tweet1);
        AppContext.getTWEET_SER().save(comment0);
        AppContext.getTWEET_SER().save(comment1);
        AppContext.getTWEET_SER().save(reply0);


        // todo :3
       /* AppContext.setPrinter(
                AppContext.getTWEET_SER().showAllTweets());*/

        // todo :5
       /* AppContext.getLIKES_SER().likeATweet(likes0);
        AppContext.getLIKES_SER().likeATweet(likes1);
        AppContext.getLIKES_SER().dislikeATweet(likes1);*/

        //todo :7
       /* AppContext.getLIKES_SER().likeATweet(likes0);
        AppContext.getLIKES_SER().likeATweet(likes1);
        AppContext.getTWEET_SER().printATweetWithDetails(tweet0);*/

        //todo :8
        /*AppContext.setPrinter(
                AppContext.getACCOUNT_SER().searchAccountByUsername("farzad"));*/

        //todo :9
        /*AppContext.getFOLLOW_SER().follow(follow0);
        AppContext.getFOLLOW_SER().follow(follow1);
        //AppContext.getFOLLOW_SER().unfollow(follow1);
        AppContext.setPrinter(
                AppContext.getFOLLOW_SER().showFollowers(account0));
        System.out.println("***");
        AppContext.setPrinter(
                AppContext.getFOLLOW_SER().showFollowing(account1));*/

        //todo :10
        //System.out.println(reply0);

       /* AppContext.setPrinter(
                AppContext.getTWEET_SER().showATweetsComments(tweet0)
        );*/
    }
}