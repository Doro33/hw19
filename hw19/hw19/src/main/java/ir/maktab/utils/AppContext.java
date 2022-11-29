package ir.maktab.utils;

import ir.maktab.dao.AccountDao;
import ir.maktab.dao.FollowDao;
import ir.maktab.dao.LikesDao;
import ir.maktab.dao.TweetDao;
import ir.maktab.dao.impl.AccountDaoImpl;
import ir.maktab.dao.impl.FollowDaoImpl;
import ir.maktab.dao.impl.LikesDaoImpl;
import ir.maktab.dao.impl.TweetDaoImpl;
import ir.maktab.service.AccountService;
import ir.maktab.service.FollowService;
import ir.maktab.service.LikesService;
import ir.maktab.service.TweetService;
import ir.maktab.service.impl.AccountServiceImpl;
import ir.maktab.service.impl.FollowServiceImpl;
import ir.maktab.service.impl.LikesServiceImpl;
import ir.maktab.service.impl.TweetServiceImpl;
import jakarta.persistence.EntityManager;
import lombok.Getter;

import java.util.Set;

public class AppContext {
    private AppContext(){}
    private final static  EntityManager ENTITY_MANAGER =
            HibernateUtils.getENTITY_MANAGER_FACTORY().createEntityManager();

    private final static AccountDao ACCOUNT_DAO = new AccountDaoImpl(ENTITY_MANAGER);
    @Getter
    private final static AccountService ACCOUNT_SER = new AccountServiceImpl(ACCOUNT_DAO);

    private final static TweetDao TWEET_DAO = new TweetDaoImpl(ENTITY_MANAGER);
    @Getter
    private final static TweetService TWEET_SER = new TweetServiceImpl(TWEET_DAO);

    private final static LikesDao LIKES_DAO = new LikesDaoImpl(ENTITY_MANAGER);
    @Getter
    private final static LikesService LIKES_SER = new LikesServiceImpl(LIKES_DAO);

    private final static FollowDao FOLLOW_DAO = new FollowDaoImpl(ENTITY_MANAGER);
    @Getter
    private final static FollowService FOLLOW_SER = new FollowServiceImpl(FOLLOW_DAO);


    public  static void setPrinter(Set input){
        if (input.size()==0)
            System.out.println("The list is empty.");
        input.forEach(System.out::println);
    }
}