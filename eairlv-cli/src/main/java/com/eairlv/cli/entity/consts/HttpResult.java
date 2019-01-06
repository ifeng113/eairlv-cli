package com.eairlv.cli.entity.consts;

import lombok.Getter;
import lombok.Setter;

/**
 * @author lv
 * @create 2018-07-23 10:24
 * @desc
 **/
public enum HttpResult {

    SUCCESS("请求成功", 1),
    FAIL("请求失败", 0),

    PARAMETER_ERROR("参数异常", 99);

    @Setter
    @Getter
    private int code;

    @Setter
    @Getter
    private String message;

    HttpResult(String message, int code) {
        this.code = code;
        this.message = message;
    }
}
