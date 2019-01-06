package com.eairlv.cli.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eairlv.cli.dao.CliDao;
import com.eairlv.cli.entity.bo.CliBO;
import com.eairlv.cli.entity.bo.CliUpdateBO;
import com.eairlv.cli.entity.po.CliPO;
import com.eairlv.cli.entity.vo.CliVO;
import com.eairlv.cli.entity.vo.PageVO;
import com.eairlv.cli.utils.BeanUtil;
import com.eairlv.cli.utils.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lv
 * @create 2018-07-23 11:25
 * @desc
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class CliService {

    @Autowired
    CliDao cliDao;

    public CliPO getMpById(Long id){
        return cliDao.selectById(id);
    }

    public PageVO<CliVO> getAllMp(Page page) {
        return PageUtil.voTransform(cliDao.getPages(page));
    }

    public void add(CliBO cliBO) {
        CliPO cli = new CliPO();
        BeanUtil.copyProperties(cliBO, cli);
        cli.setCreateTime(System.currentTimeMillis());
        cliDao.insert(cli);
    }

    public void update(CliUpdateBO cliUpdateBO) {
        CliPO cli = cliDao.selectById(cliUpdateBO.getId());
        cli.setInfo(cliUpdateBO.getInfo());
        cli.setIcon(cliUpdateBO.getIcon());
        cli.setModifyTime(System.currentTimeMillis());
        cliDao.updateById(cli);
    }

    public void delete(Long id) {
        cliDao.deleteById(id);
    }
}
