package com.eairlv.cli.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.eairlv.cli.entity.Result;
import com.eairlv.cli.entity.bo.CliBO;
import com.eairlv.cli.entity.bo.CliUpdateBO;
import com.eairlv.cli.entity.bo.PageBO;
import com.eairlv.cli.entity.po.CliPO;
import com.eairlv.cli.entity.vo.CliVO;
import com.eairlv.cli.entity.vo.PageVO;
import com.eairlv.cli.service.CliService;
import com.eairlv.cli.utils.BeanUtil;
import com.eairlv.cli.utils.PageUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author lv
 * @create 2018-07-23 10:12
 * @desc
 **/
@Api(description = "测试接口", tags = "CLI-CONTROLLER")
@RestController
@RequestMapping("/cli")
@Log4j2
public class CliController extends BaseController {

    @Autowired
    CliService cliService;

    @GetMapping("/{id}")
    @ApiOperation("通过ID获取对象")
    public Result<CliVO> get(@PathVariable @ApiParam(required = true, value = "对象ID") Long id){
        CliPO mybatisPlus = cliService.getMpById(id);
        return Result.ok(BeanUtil.copyProperties(mybatisPlus, CliVO.class));
    }

    @PostMapping
    @ApiOperation("新增对象")
    public Result add(@RequestBody CliBO cliBO){
        cliService.add(cliBO);
        return Result.ok();
    }

    @PutMapping
    @ApiOperation("修改对象")
    public Result update(@RequestBody CliUpdateBO cliUpdateBO){
        cliService.update(cliUpdateBO);
        return Result.ok();
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除对象")
    public Result delete(@PathVariable Long id){
        cliService.delete(id);
        return Result.ok();
    }

    @GetMapping
    @ApiOperation("获取所有对象")
    public Result<PageVO<CliVO>> get(PageBO pageBO){
        PageVO<CliVO> mybatisPlus = cliService.getAllMp(PageUtil.boTransform(pageBO));
        return Result.ok(mybatisPlus);
    }

}
