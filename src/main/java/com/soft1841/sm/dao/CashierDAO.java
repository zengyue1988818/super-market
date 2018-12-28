package com.soft1841.sm.dao;


/**
 * 收银员DAO接口
 * @author zengyue
 * 2018.12.24
 */
import com.soft1841.sm.entity.Cashier;

import java.sql.SQLException;
import java.util.List;

public interface CashierDAO {

    /**
     * 根据工号查询收银员
     * @param account
     * @return
     * @throws SQLException
     */
    Cashier getCashierByAccount(String account) throws SQLException;
}
