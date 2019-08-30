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
     * @MethodName: update
     * @param: [entity]
     * @Description: 更新
     * @author: 张本学
     * @date: 2018-11-12 17:49
     * @since: JDK 1.8
     *//*

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
