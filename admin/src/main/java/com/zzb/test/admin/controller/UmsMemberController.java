package com.zzb.test.admin.controller;

import com.zzb.test.admin.common.CommonResult;
import com.zzb.test.admin.service.UmsMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 会员登录注册管理controller
 * Created by zzb on 2019/11/19 19:13
 */
@Api(tags = "UmsMemberController", description = "会员登录注册管理")
@Controller
public class UmsMemberController {

    @Autowired
    private UmsMemberService umsMemberService;

    @ApiOperation("获取手机验证码")
    @RequestMapping(value = "/admin/member/getSmsCode", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult getSmsCode(String telephone){
        String smsCode = umsMemberService.generateSmsCode(telephone);
        if (!StringUtils.isEmpty(smsCode)) {
            return CommonResult.success(smsCode,"获取验证码成功");
        }
        return CommonResult.failed("获取验证码失败");
    }

    @ApiOperation("校验输入验证码")
    @RequestMapping(value = "/admin/member/validSmsCode",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult validSmsCode(String telephone,String smsCode){

        return umsMemberService.validSmsCode(telephone,smsCode);
    }
}
