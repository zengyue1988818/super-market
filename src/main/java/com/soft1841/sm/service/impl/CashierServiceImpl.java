package com.soft1841.sm.service.impl;

/**
 * @author zengyue
 * 2018.12.27
 */
import com.soft1841.sm.dao.CashierDAO;
import com.soft1841.sm.entity.Cashier;
import com.soft1841.sm.service.CashierService;
import com.soft1841.sm.until.DAOFactory;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CashierServiceImpl implements CashierService{
    private CashierDAO cashierDAO = DAOFactory.getCashierDAOInstance();

    @Override
    public boolean login(String account, String password) {
        Cashier cashier = null;
        try {
            cashier = cashierDAO.getCashierByAccount(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //根据账号查找成功
        if (cashier != null) {
            //比较密码
            if (password.equals(cashier.getPassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Cashier> getAllCashiers() {
        List<Cashier> cashierList = new ArrayList<>();
        try {
            cashierList = cashierDAO.selectCashiers();
        } catch (SQLException e) {
            //友好处理
            System.err.println("查询所有收银员信息出现异常");
        }
        return cashierList;
    }

    @Override
    public void deleteCashier(long id) {
        try {
            cashierDAO.deleteById(id);
        } catch (SQLException e) {
            System.err.println("删除收银员信息出现异常");
        }
    }

    @Override
    public Long insertCashier(Cashier cashier) {
        long result = 0;
        try {
            result = cashierDAO.insertCashier(cashier);
        } catch (SQLException e) {
            System.err.println("新增收银员信息出现异常");
        }
        return result;
    }
}
