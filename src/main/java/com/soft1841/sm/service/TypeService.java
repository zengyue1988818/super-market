package com.soft1841.sm.service;

/**
 * 商品类别服务层的重构
 * @auther zengyue
 * 2018 12.26
 */
import com.soft1841.sm.entity.Type;

import java.util.List;


public interface TypeService {
    /**
     * 获取所有商品类别的功能
     * @return
     */
    List<Type> getAllTypes();

    /**
     * 根据id查询类别
     * @param id
     * @return
     */
    Type getType(long id);

    /**
     * 添加类别
     * @param type
     */
    Long addType(Type type);

    /**
     * 删除类别
     * @param id
     */
    void deleteType(long id);
}
