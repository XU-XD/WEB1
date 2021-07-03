package com.dcs.Account.dao;

import com.dcs.Account.domain.Account;

public interface AccountDao {
    Account check(String username, String password);

    void sgin(Account account);
}
