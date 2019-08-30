package com.hk.oa.common.msg;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @ClassName: QueryDto
 * @Package: com.hk.insurance.common.utils
 * @Description: 查询参数
 * @author: 张本学
 * @date: 2018-11-13 11:25
 * @version: 1.0.0
 */
public class QueryDto implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 当前页码
     */
    @NotNull(message = "分页信息起始页不能为空！")
    @ApiModelProperty(value = "当前页码", required = true)
    private int page = 1;
    /**
     * 每页条数
     */
    @NotNull(message = "分页信息分页大小不能为空！")
    @ApiModelProperty(value = "分页大小", required = true)
    private int limit = 10;

    public QueryDto() {
    }

    public QueryDto(int page, int limit) {
        this.page = page;
        this.limit = limit;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

}
