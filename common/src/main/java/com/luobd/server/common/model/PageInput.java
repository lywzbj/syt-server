package com.luobd.server.common.model;

import io.swagger.annotations.ApiModelProperty;

public class PageInput {


    @ApiModelProperty(value = "页码",example = "1")
    private Integer pageIndex;




    @ApiModelProperty(value = "每页数量",example = "20")
    private Integer pageSize;


    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
