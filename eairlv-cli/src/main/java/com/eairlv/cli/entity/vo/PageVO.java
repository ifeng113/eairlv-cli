package com.eairlv.cli.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author lv
 * @create 2018-12-03 21:33
 * @desc
 **/
@Data
@Builder
public class PageVO<T> {

    @ApiModelProperty("当前页数")
    private Long index;

    @ApiModelProperty("数据总数")
    private Long count;

    @ApiModelProperty("当前页大小")
    private Long size;

    @ApiModelProperty("数据")
    private List<T> data;

}
