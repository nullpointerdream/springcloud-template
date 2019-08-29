package com.hk.oa.common.rest;

import com.hk.oa.common.biz.BaseBiz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName: BaseController
 * @Package: com.hk.insurance.common.rest
 * @Description: 基础controller
 * 封装了常用的增、删、改、查功能
 * @author: 张本学
 * @date: 2018-11-12 17:06
 * @version: 1.0.0
 */
@Slf4j
public class BaseController<Biz extends BaseBiz, Entity> extends BaseInfoController{

    @Autowired
    protected Biz baseBiz;

    /**
     * @MethodName: add
     * @param: [entity]
     * @Description: 添加功能
     * @author: 张本学
     * @date: 2018-11-12 17:13
     * @since: JDK 1.8
     */
    /*@ApiOperation(value = "新增", notes = "新增")
    @Validated //表单校验
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult<Entity> add(@RequestBody Entity entity) {
        baseBiz.insertSelective(entity);
        return  ResponseResultUtil.buildSuccessResponseResult("添加成功",null);
    }

    *//**
     * @MethodName: get
     * @param: [id]
     * @Description: 根据Id查询
     * @author: 张本学
     * @date: 2018-11-12 17:16
     * @since: JDK 1.8
     *//*
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult<Entity> get(@PathVariable int id) {
        Object o = baseBiz.selectById(id);
        return  ResponseResultUtil.buildSuccessResponseResult("查询成功",(Entity)o);
    }

    *//**
     * @MethodName: update
     * @param: [entity]
     * @Description: 更新
     * @author: 张本学
     * @date: 2018-11-12 17:49
     * @since: JDK 1.8
     *//*
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "更新", notes = "更新")
    @Validated //表单校验
    public ResponseResult<Entity> update(@RequestBody Entity entity) {
        return  ResponseResultUtil.buildSuccessResponseResult("更新成功",null);
    }

    *//**
     * @MethodName: remove
     * @param: [id]
     * @Description: 删除
     * @author: 张本学
     * @date: 2018-11-12 17:50
     * @since: JDK 1.8
     *//*
    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult<Entity> remove(@PathVariable int id) {
        baseBiz.deleteById(id);
        return ResponseResultUtil.buildSuccessResponseResult("删除成功",null);
    }

    *//**
     * @MethodName: all
     * @Description: 查询所有对象
     * @author: 张本学
     * @date: 2018-11-12 17:51
     * @since: JDK 1.8
     *//*
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult all() {
        List<Entity> list =baseBiz.selectListAll();
        return ResponseResultUtil.buildSuccessResponseResult("",list);
    }
*/
    /**
     * @MethodName: list
     * @param: [params]
     * @Description: 分页查询数据
     * @author: 张本学
     * @date: 2018-11-12 17:52
     * @since: JDK 1.8
     *//*
    @RequestMapping(value = "/page", method = RequestMethod.GET)
    @ResponseBody
    public TableResultResponse<Entity> list(@RequestParam Map<String, Object> params) {
        // 查询列表数据
        return baseBiz.selectByQuery(params);
    }
*/


}
