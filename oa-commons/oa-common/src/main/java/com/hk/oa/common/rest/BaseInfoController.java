package com.hk.oa.common.rest;

import com.hk.oa.common.context.BaseContextHandler;

/**
 * @author Shisan
 * @version V1.0.0
 * @Package com.hk.insurance.common.rest
 * @ClassName: BaseInfoController
 * @Description:
 * @date 2019年01月17日 14:59
 */
public class BaseInfoController extends FileController{

    /**
     * @MethodName: getCurrentUserName
     * @Description: 获取当前用户名
     * @author: 张本学
     * @date: 2018-11-12 17:09
     * @since: JDK 1.8
     */
    public String getCurrentUserName() {

        return BaseContextHandler.getAccount();
    }

    /**
     * 获取当前用户ID
     * @auth Shisan
     * @return
     */
    public Integer getCurrentUserId(){
        return BaseContextHandler.getUserId();
    }

    /**
     * 获取当前用户 名字
     * @return
     */
    public String getCurrentName(){
        return BaseContextHandler.getName();
    }



    /**
     * @method_name: getUserType
     * @describe: 获取当前用户用户类型
     * @author: 张本学
     * @creat_date: 2018/12/21
     * @creat_time: 1:42 PM
     * @since: JDK 1.8
     */
    public Integer getDepId() {
        return BaseContextHandler.getDepId();
    }


}
