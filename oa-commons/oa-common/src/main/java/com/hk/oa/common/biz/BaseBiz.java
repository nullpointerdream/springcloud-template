package com.hk.oa.common.biz;

import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @program: hk-oa-master
 * @description: s
 * @author: 陈家乐
 * @create: 2019-08-26 11:00
 **/

public abstract class  BaseBiz<M extends Mapper<T>, T> {
    
    @Autowired
    protected M mapper;

    public void setMapper(M mapper) {
        this.mapper = mapper;
    }

    /**
     * @MethodName: selectOne
     * @param: [entity]
     * @Description: 根据实体中的属性进行查询，只能有一个返回值，
     * 有多个结果是抛出异常，查询条件使用等号
     * @author: 张本学
     * @date: 2018/3/15 上午10:40
     * @since: JDK 1.8
     */
    public T selectOne(T entity) {
        return mapper.selectOne(entity);
    }

    /**
     * @MethodName: selectById
     * @param: [id]
     * @Description: 根据主键字段进行查询，方法参数必须包含完整的主键属性，
     * 查询条件使用等号
     * @author: 张本学
     * @date: 2018/3/15 上午10:40
     * @since: JDK 1.8
     */
    public T selectById(Object id) {
        return mapper.selectByPrimaryKey(id);
    }

    /**
     * @MethodName: selectList
     * @param: [entity]
     * @Description: 根据实体中的属性值进行查询，查询条件使用等号
     * @author: 张本学
     * @date: 2018/3/15 上午10:41
     * @since: JDK 1.8
     */
    public List<T> selectList(T entity) {
        return mapper.select(entity);
    }

    /**
     * @MethodName: selectListAll
     * @Description: 查询全部结果
     * @author: 张本学
     * @date: 2018/3/15 上午10:51
     * @since: JDK 1.8
     */
    public List<T> selectListAll() {
        return mapper.selectAll();
    }

    /**
     * @MethodName: selectCount
     * @param: [entity]
     * @Description: 根据实体中的属性查询总数，查询条件使用等号
     * @author: 张本学
     * @date: 2018/3/15 上午10:51
     * @since: JDK 1.8
     */
    public Long selectCount(T entity) {
        return new Long(mapper.selectCount(entity));
    }

    /**
     * @MethodName: insert
     * @param: [entity]
     * @Description: 保存一个实体，null的属性也会保存，
     * 不会使用数据库默认值
     * @author: 张本学
     * @date: 2018/3/15 下午1:41
     * @since: JDK 1.8
     */
    public void insert(T entity) {
        mapper.insert(entity);
    }

    /**
     * @MethodName: insertSelective
     * @param: [entity]
     * @Description: 保存一个实体，null的属性不会保存，
     * 会使用数据库默认值
     * @author: 张本学
     * @date: 2018/3/15 下午5:50
     * @since: JDK 1.8
     */
    public void insertSelective(T entity) {
        mapper.insertSelective(entity);
    }

    /**
     * @MethodName: updateById
     * @param: [entity]
     * @Description: 根据主键更新实体全部字段，null值会被更新
     * @author: 张本学
     * @date: 2018/3/15 下午5:48
     * @since: JDK 1.8
     */
    public void updateById(T entity) {
        mapper.updateByPrimaryKey(entity);
    }

    /**
     * @MethodName: updateSelectiveById
     * @param: [entity]
     * @Description: 根据主键更新属性不为null的值
     * @author: 张本学
     * @date: 2018/3/15 下午5:48
     * @since: JDK 1.8
     */
    public void updateSelectiveById(T entity) {
        mapper.updateByPrimaryKeySelective(entity);

    }

    /**
     * @MethodName: delete
     * @param: [entity]
     * @Description: 根据实体属性作为条件进行删除，查询条件使用等号
     * @author: 张本学
     * @date: 2018/3/15 下午5:50
     * @since: JDK 1.8
     */
    public void delete(T entity) {
        mapper.delete(entity);
    }

    /**
     * @MethodName: deleteById
     * @param: [id]
     * @Description: 根据主键字段进行删除，方法参数必须包含完整的主键属性
     * @author: 张本学
     * @date: 2018/3/15 下午5:49
     * @since: JDK 1.8
     */
    public void deleteById(Object id) {
        mapper.deleteByPrimaryKey(id);
    }



}
