package com.dcs.Account.dao.Impl;

import com.dcs.Account.dao.AccountDao;
import com.dcs.Account.domain.Account;
import com.dcs.Account.until.DataSourceUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

/**
 * projectName:AccountProject
 * author:dcs
 * time:2021/6/27 19:19
 * description:
 */
public class AccountDaoImpl implements AccountDao {
    private QueryRunner queryRunner = new QueryRunner(DataSourceUtil.getDataSource());

    /**
     * 功能：登录功能的实现
     * 实现方式：    通过QueryRunner的query()方法实现对单条记录的读取，再传入前端获取的数据返回一个结果集
     *          若结果集不为空则证明数据库中存在这条记录，最终实现跳转。
     */
    @Override
    public Account check(String username, String password) {
        String sql = " select username, password from accountuser where username = ? and password = ? ";

        try {
           return queryRunner.query(sql, new BeanHandler<>(Account.class), username, password);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 功能：注册功能的实现
     * 实现方式：    通过QureyRunner的update()方法实现数据的插入，
     */

    @Override
    public void sgin(Account account) {
        String sql = "insert into accountuser values(null,?,?,0)";
        Object[] param = {account.getUsername(),account.getPassword()};
        try {
            queryRunner.update(sql, param);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
