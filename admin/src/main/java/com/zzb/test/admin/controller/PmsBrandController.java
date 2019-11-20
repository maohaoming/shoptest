package com.zzb.test.admin.controller;

import com.zzb.test.admin.common.CommonPage;
import com.zzb.test.admin.common.CommonResult;
import com.zzb.test.admin.mbg.model.PmsBrand;
import com.zzb.test.admin.service.PmsBrandService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 品牌管理Controller
 * Created by zzb on 2019/11/15 10:28
 */
@Api(tags = "PmsBrandController",description = "商品品牌管理")
@Controller
public class PmsBrandController {

    @Autowired
    private PmsBrandService pmsBrandService;

    private static final Logger logger = LoggerFactory.getLogger(PmsBrandController.class);

    @ApiOperation("分页获取所有品牌")
    @RequestMapping(value = "/admin/brand/getList", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<PmsBrand>> getList(@RequestParam(value = "pageNum", defaultValue = "1") @ApiParam("分页页码") Integer pageNum,
                                                           @RequestParam(value = "pageSize", defaultValue = "10") @ApiParam("每页数量") Integer pageSize){
        List<PmsBrand> list = pmsBrandService.getList(pageNum,pageSize);
        logger.info("分页查询所有品牌==》" + list);
        return CommonResult.success(CommonPage.restPage(list));
    }

    @ApiOperation("添加品牌")
    @RequestMapping(value = "/admin/brand/insert", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult insert(@ApiParam("品牌信息") PmsBrand pmsBrand){
        int count = pmsBrandService.insert(pmsBrand);
        logger.info("添加品牌==》" + count);
        if (count>0) {
            return CommonResult.success("添加品牌成功");
        }
        return CommonResult.failed();
    }

    @ApiOperation("删除品牌")
    @RequestMapping(value = "/admin/brand/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@ApiParam("品牌id") Long id){
        int count = pmsBrandService.delete(id);
        logger.info("删除品牌==》" + count);
        if (count>0) {
            return CommonResult.success("删除品牌成功");
        }
        return CommonResult.failed();
    }

    @ApiOperation("更新品牌")
    @RequestMapping(value = "/admin/brand/update", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult update(@ApiParam("修改主体") PmsBrand pmsBrand){
        int count = pmsBrandService.update(pmsBrand);
        logger.info("更新品牌==》" + count);
        if (count>0) {
            return CommonResult.success("更新品牌成功");
        }
        return CommonResult.failed();
    }

}
