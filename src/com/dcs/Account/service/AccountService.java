package com.dcs.Account.service;

import com.dcs.Account.domain.Account;

public interface AccountService {
    Account check(String username, String password);

    void sgin(Account account);
}
