package com.luobd.server.common.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class ResponsePageData<T> {


    @ApiModelProperty(value = "错误码    200-正常   500-异常")
    private int code;



    @ApiModelProperty(value = "错误信息")
    private String msg = "success";



    @ApiModelProperty(value = "数据")
    private List<T> data;



    @ApiModelProperty(value = "总数")
    private long total;


    public  static <T> ResponsePageData<T> success(List<T> data,long total) {
        ResponsePageData<T> responseData = new ResponsePageData<>();
        responseData.setData(data);
        responseData.setCode(200);
        responseData.setTotal(total);
        return  responseData;
    }

    public  static <T> ResponsePageData<T> error(String msg) {
        ResponsePageData<T> responseData = new ResponsePageData<>();
        responseData.setCode(500);
        responseData.setMsg(msg);
        return  responseData;
    }









}
