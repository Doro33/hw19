package ir.maktab.service.impl;

import ir.maktab.base.service.impl.BaseServiceImpl;
import ir.maktab.dao.AccountDao;
import ir.maktab.entity.Account;
import ir.maktab.service.AccountService;

import java.util.Set;

public class AccountServiceImpl extends BaseServiceImpl<Account,Integer, AccountDao> implements AccountService {
    public AccountServiceImpl(AccountDao repository) {
        super(repository);
    }

    @Override
    public Set<String> searchAccountByUsername(String input) {
        return repository.searchAccountByUsername(input);
    }
}