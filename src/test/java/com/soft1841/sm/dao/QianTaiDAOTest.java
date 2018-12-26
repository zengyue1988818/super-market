package com.soft1841.sm.dao;

import com.soft1841.sm.entity.QianTai;
import com.soft1841.sm.utils.DAOFactory;
import org.junit.Test;

/**
 * 前台测试zengyue
 * 2018.12.26
 */
import java.sql.SQLException;

public class QianTaiDAOTest {
    private QianTaiDAO qianTaiDAO = (QianTaiDAO) DAOFactory.getQianTaiDAOInstance();

    @Test
    public void getQianTaiByNumber() throws SQLException {
        QianTai qianTai = qianTaiDAO.getQianTaiByNumber("2");
        System.out.println(qianTai);
    }

}