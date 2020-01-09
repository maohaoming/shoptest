package com.zzb.test.admin.controller;

import com.zzb.test.admin.common.CommonResult;
import com.zzb.test.admin.dto.OssCallbackResult;
import com.zzb.test.admin.dto.OssPolicyResult;
import com.zzb.test.admin.service.OssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Oss文件管理Controller
 * Created by zzb on 2020/1/7 15:04
 */
@Api(tags = "OssController", description = "Oss文件管理")
@Controller
public class OssController {
    @Autowired
    private OssService ossService;

    @ApiOperation("oss上传签名生成")
    @RequestMapping(value = "/admin/oss/policy", method = RequestMethod.GET)
    @ResponseBody
    public CommonResult policy(){
        OssPolicyResult policy = ossService.policy();
        return CommonResult.success(policy);
    }

    @ApiOperation("oss上传成功回调")
    @RequestMapping(value = "/admin/oss/callback", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult callback(HttpServletRequest request){
        OssCallbackResult callback = ossService.callback(request);
        return CommonResult.success(callback);
    }
}
