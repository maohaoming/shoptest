package com.zzb.test.admin.controller;

import cn.hutool.core.lang.Assert;
import com.zzb.test.admin.common.CommonResult;
import com.zzb.test.admin.mbg.model.UmsAdmin;
import com.zzb.test.admin.mbg.model.UmsPermission;
import com.zzb.test.admin.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户管理Controller
 * Created by zzb on 2019/11/22 9:37
 */
@Api(tags = "UmsAdminController", description = "用户管理")
@Controller
public class UmsAdminController {
    @Autowired
    private UmsAdminService umsAdminService;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    /**
     * 用户注册
     * @param umsAdminParam
     * @return
     */
    @ApiOperation("用户注册")
    @ResponseBody
    @RequestMapping(value = "/admin/register", method = RequestMethod.POST)
    public CommonResult register(@RequestBody UmsAdmin umsAdminParam){
        String originPassword = umsAdminParam.getPassword();
        //注册用户账号
        UmsAdmin umsAdmin = umsAdminService.register(umsAdminParam);
        Assert.notNull(umsAdmin,"用户注册失败");
        //注册成功后自动登录
        String token = umsAdminService.login(umsAdminParam.getUsername(),originPassword);
        if (StringUtils.isEmpty(token)) {
            return CommonResult.failed("自动登录失败!!");
        }
        Map<String,String> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead", tokenHead);

        return CommonResult.success(tokenMap,"自动登录成功!!");
    }

    /**
     * 用户登录
     * @param umsAdminParam
     * @return
     */
    @ApiOperation("用户登录")
    @ResponseBody
    @RequestMapping(value = "/admin/login", method = RequestMethod.POST)
    public CommonResult login(@RequestBody UmsAdmin umsAdminParam){
        //根据输入的用户名和密码生成token
        String token = umsAdminService.login(umsAdminParam.getUsername(),umsAdminParam.getPassword());
        if (StringUtils.isEmpty(token)) {
            return CommonResult.failed("用户名或密码错误!!");
        }
        Map<String,String> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        tokenMap.put("tokenHead", tokenHead);

        return CommonResult.success(tokenMap,"登录成功");
    }

    /**
     * 获取用户所有的权限
     * @param adminId
     * @return
     */
    @ApiOperation("获取用户所有权限")
    @ResponseBody
    @RequestMapping(value = "/admin/getPermissionList/{adminId}", method = RequestMethod.POST)
    public CommonResult<List<UmsPermission>> getPermissionList(@PathVariable Long adminId){
        List<UmsPermission> permissionList = umsAdminService.getPermissionList(adminId);
        return CommonResult.success(permissionList);
    }


}
