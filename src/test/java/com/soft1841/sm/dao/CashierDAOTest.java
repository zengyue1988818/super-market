package com.soft1841.sm.dao;

import com.soft1841.sm.entity.Cashier;
import com.soft1841.sm.until.DAOFactory;
import org.junit.Test;


import java.sql.SQLException;
import java.util.List;


public class CashierDAOTest {
    //从工厂中获取到CashierDAO的实例
    private CashierDAO cashierDAO = DAOFactory.getCashierDAOInstance();

    @Test
    public void getCashierByAccount() throws SQLException {
        Cashier cashier = cashierDAO.getCashierByAccount("180180");
        System.out.println(cashier);
    }

    @Test
    public void selectCashiers() throws SQLException {
        List<Cashier> cashierList = cashierDAO.selectCashiers();
        cashierList.forEach(entity -> System.out.println(entity));
    }

    @Test
    public void deleteById() throws SQLException {
        cashierDAO.deleteById(3);
    }

    @Test
    public void insertCashier() throws SQLException {
        Cashier cashier = new Cashier();
        cashier.setId(5l);
        cashier.setName("李伟国");
        cashier.setNumber("01");
        cashier.setSexuality("男");
        cashier.setAge("18");
        cashier.setPicture("https://upload-images.jianshu.io/upload_images/14956547-f27fhttp://img5.duitang.com/uploads/item/201410/12/20141012103955_QdvGz.thumb.700_0.jpeg");
        cashier.setAccount("180180");
        cashier.setPassword("123456");
        System.out.println(cashierDAO.insertCashier(cashier));
    }
}