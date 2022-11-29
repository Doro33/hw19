package ir.maktab.service;

import ir.maktab.base.service.BaseService;
import ir.maktab.entity.Account;
import ir.maktab.entity.Follow;

import java.util.List;
import java.util.Set;

public interface FollowService extends BaseService<Follow, Integer> {
    Follow follow(Follow follow);
    void unfollow(Follow follow);
    Set<String> showFollowers(Account account);
    Set<String> showFollowing(Account account);
}