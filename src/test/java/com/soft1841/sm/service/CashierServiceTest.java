package com.soft1841.sm.service;

import com.soft1841.sm.entity.Cashier;
import com.soft1841.sm.until.ServiceFactory;
import org.junit.Test;

import static org.junit.Assert.*;


public class CashierServiceTest {

    private CashierService cashierService = ServiceFactory.getCashierServiceInstance();

    @Test
    public void login() {
        boolean flag = cashierService.login("180180","123456");
        assertEquals(true,flag);
    }
    @Test
    public void deleteCashier() {
        cashierService.deleteCashier(5);
    }

    @Test
    public void insertCashier() {
        Cashier cashier = new Cashier();
        cashier.setId(5l);
        cashier.setName("李伟国");
        cashier.setNumber("01");
        cashier.setSexuality("男");
        cashier.setAge("18");
        cashier.setPicture("https://upload-images.jianshu.io/upload_images/14956547-f27fhttp://img5.duitang.com/uploads/item/201410/12/20141012103955_QdvGz.thumb.700_0.jpeg");
        cashier.setAccount("180180");
        cashier.setPassword("123456");

        System.out.println(cashier);
    }
}
