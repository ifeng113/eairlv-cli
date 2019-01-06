package com.eairlv.cli.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eairlv.cli.entity.bo.PageBO;
import com.eairlv.cli.entity.vo.PageVO;

/**
 * @author lv
 * @create 2018-12-03 18:24
 * @desc
 **/
public class PageUtil {

    public static Page boTransform(PageBO pageBO) {
        Page page = new Page();
        page.setCurrent(pageBO.getIndex());
        page.setSize(pageBO.getSize());
        return page;
    }

    public static <T> PageVO<T> voTransform(Page<T> page) {
        return PageVO.<T>builder()
                .index(page.getCurrent())
                .size(page.getSize())
                .count(page.getTotal())
                .data(page.getRecords())
                .build();
    }
}
