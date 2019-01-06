package com.eairlv.cli.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lv
 * @create 2018-07-23 13:44
 * @desc
 **/
@Data
public class CliVO {

    @ApiModelProperty("对象ID")
    private Long id;

    @ApiModelProperty("基本信息")
    private String info;

    @ApiModelProperty("图标")
    private String icon;
}
