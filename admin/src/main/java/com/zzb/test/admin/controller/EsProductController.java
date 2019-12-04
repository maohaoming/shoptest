package com.zzb.test.admin.controller;

import com.zzb.test.admin.common.CommonPage;
import com.zzb.test.admin.common.CommonResult;
import com.zzb.test.admin.elasticsearch.document.EsProduct;
import com.zzb.test.admin.service.EsProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ES搜索商品Controller
 * Created by zzb on 2019/12/4 14:06
 */
@Controller
@Api(tags = "EsProductController",description = "ES商品搜索")
public class EsProductController {
    @Autowired
    private EsProductService esProductService;

    @ApiOperation("从数据库导入ES商品数据")
    @RequestMapping(value = "/esProduct/importAll",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult<Integer> importAll(){
        int count = esProductService.importAll();
        return CommonResult.success(count);
    }

    @ApiOperation("根据id删除商品")
    @RequestMapping(value = "/esProduct/delete/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteById(@PathVariable Long id){
        esProductService.delete(id);
        return CommonResult.success("删除成功");
    }

    @ApiOperation("批量删除商品")
    @RequestMapping(value = "/esProduct/deletes",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult deleteById(List<Long> ids){
        esProductService.deletes(ids);
        return CommonResult.success("删除成功");
    }

    @ApiOperation("根据id创建商品")
    @RequestMapping(value = "/esProduct/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(Long id){
        EsProduct esProduct = esProductService.create(id);
        if (StringUtils.isEmpty(esProduct)) {
            return CommonResult.failed("创建失败");
        }
        return CommonResult.success("创建成功");
    }

    @ApiOperation("搜索商品")
    @RequestMapping(value = "/esProduct/search",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<EsProduct>> search(@RequestParam(required = false) String keyword,
                                                      @RequestParam(required = false, defaultValue = "0") Integer pageNum,
                                                      @RequestParam(required = false, defaultValue = "5") Integer pageSize){
        Page<EsProduct> esProductPage = esProductService.searchPage(keyword,pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(esProductPage));
    }
}
