package com.soft1841.sm.service;

import com.soft1841.sm.entity.Cashier;

import java.util.List;

/**
 * @author zengyue
 * 2018.12.28
 */
public interface CashierService {

    /**
     * 登录功能
     * @param account
     * @param password
     * @return
     */
    boolean login(String account, String password);

    /**
     * 查询所有收银员信息
     * @return
     */
    List<Cashier> getAllCashiers();

    /**
     * 根据id删除收银员
     * @param id
     */
    void deleteCashier(long id);

    /**
     * 新增一个收银员，返回自增主键
     * @param cashier
     * @return
     */
    Long insertCashier(Cashier cashier);

}
