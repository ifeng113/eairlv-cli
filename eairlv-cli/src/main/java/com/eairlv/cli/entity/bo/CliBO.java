package com.eairlv.cli.entity.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lv
 * @create 2018-07-23 17:44
 * @desc
 **/
@Data
public class CliBO {

    @ApiModelProperty("信息")
    private String info;

    @ApiModelProperty("图标")
    private String icon;
}
