package ir.maktab.dao;

import ir.maktab.base.dao.BaseDao;
import ir.maktab.entity.Account;

import java.util.Set;

public interface AccountDao extends BaseDao<Account,Integer> {
    Set<String> searchAccountByUsername(String input);
}