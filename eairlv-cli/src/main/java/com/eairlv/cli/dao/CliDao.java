package com.eairlv.cli.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eairlv.cli.entity.po.CliPO;
import com.eairlv.cli.entity.vo.CliVO;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author lv
 * @create 2018-07-23 11:26
 * @desc
 **/
@Mapper
public interface CliDao extends BaseMapper<CliPO> {

    /**
     * 获取对象（分页）
     * @param page
     * @return
     */
    Page<CliVO> getPages(Page page);
}
