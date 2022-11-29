package ir.maktab.service;

import ir.maktab.base.service.BaseService;
import ir.maktab.entity.Account;

import java.util.Set;

public interface AccountService extends BaseService<Account,Integer> {
    Set<String> searchAccountByUsername(String input);
}