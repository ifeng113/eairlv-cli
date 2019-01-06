package com.eairlv.cli.entity.po;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @author lv
 * @create 2018-07-24 8:55
 * @desc
 **/
@Data
public class BasePO {

    private Long id;

    @Version
    private Integer version;

    @TableLogic
    private boolean deleteFlag;

    private Long createTime;

    private Long modifyTime;
}
