package com.soft1841.sm.dao;

/**
 * 图书类别DAO接口
 * @auther zengyue
 * 2018 12.26
 */
import com.soft1841.sm.entity.Type;

import java.sql.SQLException;
import java.util.List;


public interface TypeDAO {

    /**
     * 新增商品类别, 返回自增主键(Long)
     * @param type
     * @return
     */
    Long insertType(Type type) throws SQLException;

    /**
     * 根据id删除类别
     * @param id
     * @return
     */
    int deleteTypeById(long id) throws SQLException;

    /**
     * 查询所有类别
     * @return
     */
    List<Type> selectAllTypes() throws SQLException;

    /**
     * 根据id查询类别信息
     * @param id
     * @return
     */
    Type getTypeById(long id) throws SQLException;
}
