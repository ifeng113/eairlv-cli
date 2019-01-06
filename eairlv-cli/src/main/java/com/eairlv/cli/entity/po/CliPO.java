package com.eairlv.cli.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author lv
 * @create 2018-07-23 11:26
 * @desc
 **/
@Data
@TableName(value = "cli")
public class CliPO extends BasePO {

    private String info;

    private String icon;
}
