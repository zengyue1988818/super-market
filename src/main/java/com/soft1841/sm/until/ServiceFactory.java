package com.soft1841.sm.until;

/**
 *
 * service工厂
 * @auther zengyue
 */
import com.soft1841.sm.dao.TypeDAO;
import com.soft1841.sm.dao.impl.TypeDAOImpl;
import com.soft1841.sm.service.AdminService;
import com.soft1841.sm.service.CashierService;
import com.soft1841.sm.service.GoodsService;
import com.soft1841.sm.service.TypeService;
import com.soft1841.sm.service.impl.AdminServiceImpl;
import com.soft1841.sm.service.impl.CashierServiceImpl;
import com.soft1841.sm.service.impl.GoodsServiceImpl;
import com.soft1841.sm.service.impl.TypeServiceImpl;


public class ServiceFactory {

    public static CashierService getCashierServiceInstance() {
        return new CashierServiceImpl();
    }

    public static AdminService getAdminServiceInstance() {
        return new AdminServiceImpl();
    }
    public static TypeService getTypeServiceInstance(){
        return new TypeServiceImpl();
    }
    public static GoodsService getGoodsServiceInstance(){
        return new GoodsServiceImpl();
    }
}


