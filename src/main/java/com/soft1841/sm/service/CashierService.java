package com.soft1841.sm.service;

/**
 * @author zengyue
 * 2018.12.24
 */
public interface CashierService {

    /**
     * 登录功能
     * @param account
     * @param password
     * @return
     */
    boolean login(String account, String password);
}
