package com.soft1841.sm.dao;


import cn.hutool.db.Entity;
import com.soft1841.sm.entity.Vip;

import javax.swing.text.html.parser.Entity;
import java.sql.SQLException;
import java.util.List;

public interface VipDAO {
    /**
     * 查询所有Vip的信息
     * @return
     * @throws SQLException
     */
    List<Entity> selectVip()throws SQLException;

    /**
     * 根据id来删除会员信息
     * @param id
     * @return
     * @throws SQLException
     */
    int deleteById(long id) throws SQLException;

    /**
     * 新增Vip的信息
     * @param vip
     * @return
     * @throws SQLException
     */
    long insertVip(Vip vip) throws SQLException;
}