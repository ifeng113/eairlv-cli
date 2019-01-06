package com.eairlv.cli.entity;

import com.eairlv.cli.entity.consts.HttpResult;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

/**
 * @author lv
 * @create 2018-07-23 10:17
 * @desc
 **/
@Data
@Builder
@Log4j2
public class Result<T> {

    @ApiModelProperty("返回码")
    private int code;

    @ApiModelProperty("返回描述")
    private String message;

    @ApiModelProperty("返回数据")
    private T data;

    /**
     * 请求成功
     * @return
     */
    public static Result ok(){
        return Result.builder()
                .code(HttpResult.SUCCESS.getCode())
                .message(HttpResult.SUCCESS.getMessage())
                .build();
    }


    public static <T> Result<T> ok(T data){
        return ok(HttpResult.SUCCESS, data);
    }

    public static <T> Result<T> ok(HttpResult httpResult, T data){
        return Result.<T>builder()
                .code(httpResult.getCode())
                .message(httpResult.getMessage())
                .data(data)
                .build();
    }

    /**
     * 请求失败
     * @return
     */
    public static Result fail(){
        return Result.builder()
                .code(HttpResult.FAIL.getCode())
                .message(HttpResult.FAIL.getMessage())
                .build();
    }

    public static <T> Result<T> fail(T data){
        return fail(HttpResult.FAIL, data);
    }

    public static <T> Result<T> fail(HttpResult httpResult, T data){
        return Result.<T>builder()
                .code(httpResult.getCode())
                .message(httpResult.getMessage())
                .data(data)
                .build();
    }

}
