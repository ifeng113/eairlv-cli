package com.eairlv.cli.entity.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author lv
 * @create 2018-12-03 18:19
 * @desc
 **/
@Data
public class PageBO {

    @ApiModelProperty("当前页")
    private Long index;

    @ApiModelProperty("页面大小")
    private Long size;
}
