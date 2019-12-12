package com.zzb.test.admin.controller;

import com.zzb.test.admin.common.CommonPage;
import com.zzb.test.admin.common.CommonResult;
import com.zzb.test.admin.mongodb.document.MemberReadHistory;
import com.zzb.test.admin.service.MemberReadHistoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 会员商品浏览记录管理Controller
 * Created by zzb on 2019/12/10 17:19
 */
@Controller
@Api(tags = "MemberReadHistoryController", description = "会员商品浏览记录管理")
public class MemberReadHistoryController {
    @Autowired
    private MemberReadHistoryService memberReadHistoryService;

    @ApiOperation("创建浏览记录")
    @RequestMapping(value = "/admin/ums/createReadHistory", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult create(@RequestBody MemberReadHistory memberReadHistory){
        if (memberReadHistoryService.create(memberReadHistory)>0) {
            return CommonResult.success("添加记录成功");
        }
        return CommonResult.failed("添加记录失败");
    }

    @ApiOperation("批量删除会员的浏览记录")
    @RequestMapping(value = "/admin/ums/deleteReadHistory",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("ids") List<String> ids){
        if (memberReadHistoryService.delete(ids)>0) {
            return CommonResult.success("删除成功");
        }
        return CommonResult.failed("删除失败");
    }

    @ApiOperation("分页查询会员的浏览记录")
    @RequestMapping(value = "/admin/ums/listPageReadHistory",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<MemberReadHistory>> listPage(@RequestParam("memberId") Long memberId,
                                                                @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                                                @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
        List<MemberReadHistory> memberReadHistoryList = memberReadHistoryService.listPage(memberId,pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(memberReadHistoryList));
    }
 }
