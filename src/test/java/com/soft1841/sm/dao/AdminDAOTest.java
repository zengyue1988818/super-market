package com.soft1841.sm.dao;

import com.soft1841.sm.entity.Admin;
import com.soft1841.sm.until.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;



public class AdminDAOTest {
    private AdminDAO adminDAO = DAOFactory.getAdminDAOInstance();

    @Test
    public void getAdminByAccount() throws SQLException {
        Admin admin = adminDAO.getAdminByAccount("180180");
        System.out.println(admin);
    }

    @Test
    public void selectAdmin() throws SQLException {
        List<Admin> adminList = adminDAO.selectAdmin();
        adminList.forEach(admin -> System.out.println(admin));
    }

}