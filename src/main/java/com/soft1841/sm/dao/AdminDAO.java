package com.soft1841.sm.dao;

/**
 * 商品类别实现
 * @auther zengyue
 * 2018 12.26
 */

import com.soft1841.sm.entity.Admin;

import java.sql.SQLException;
import java.util.List;


public interface AdminDAO {

    /**
     * 根据账号查询管理员
     * @param account
     * @return
     * @throws SQLException
     */
    Admin getAdminByAccount(String account) throws SQLException;

    /**
     * 查询所有管理员
     * @return
     * @throws SQLException
     */
    List<Admin> selectAdmin() throws SQLException;
}
