package com.dcs.Account.service.Impl;

import com.dcs.Account.dao.AccountDao;
import com.dcs.Account.dao.Impl.AccountDaoImpl;
import com.dcs.Account.domain.Account;
import com.dcs.Account.service.AccountService;

/**
 * projectName:AccountProject
 * author:dcs
 * time:2021/6/27 19:16
 * description:
 */
public class AccountServiceImpl implements AccountService {
    AccountDao accountDao = new AccountDaoImpl();
    @Override
    public Account check(String username, String password) {
        return accountDao.check(username, password);
    }

    @Override
    public void sgin(Account account) {
         accountDao.sgin( account);
    }
}
