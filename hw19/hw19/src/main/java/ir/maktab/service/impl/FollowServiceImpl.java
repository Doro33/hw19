package ir.maktab.service.impl;

import ir.maktab.base.service.impl.BaseServiceImpl;
import ir.maktab.dao.FollowDao;
import ir.maktab.entity.Account;
import ir.maktab.entity.Follow;
import ir.maktab.service.FollowService;

import java.util.Set;

public class FollowServiceImpl extends BaseServiceImpl<Follow,Integer, FollowDao> implements FollowService {
    public FollowServiceImpl(FollowDao repository) {
        super(repository);
    }

    @Override
    public Follow follow(Follow follow) {
        return save(follow);
    }

    @Override
    public void unfollow(Follow follow) {
        delete(follow);
    }

    @Override
    public Set<String> showFollowers(Account account) {
        return repository.showFollowers(account);
    }

    @Override
    public Set<String> showFollowing(Account account) {
        return repository.showFollowing(account);
    }
}