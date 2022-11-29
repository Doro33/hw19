package ir.maktab.dao;

import ir.maktab.base.dao.BaseDao;
import ir.maktab.entity.Account;
import ir.maktab.entity.Follow;

import java.util.List;
import java.util.Set;

public interface FollowDao extends BaseDao<Follow,Integer> {
    Set<String> showFollowers(Account account);
    Set<String> showFollowing(Account account);
}