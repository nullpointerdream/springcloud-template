package com.hk.oa.common.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Shisan
 * @version V1.0.0
 * @Package com.hk.insurance.common.vo
 * @ClassName: QueryVo
 * @Description:
 * @date 2018年11月19日 19:39
 */
@Data
public class QueryVo implements Serializable {

    private static final long serialVersionUID = 9013449660018308950L;
    /**
     * 起始页
     */
    private Integer page;

    /**
     * 分页大小
     */
    private Integer pageSize;

    /**
     * 总记录条数
     */
    private Long total;

    /**
     * 数据信息
     */
    private Object data;

}
