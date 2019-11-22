package com.zzb.test.admin.service;

import com.zzb.test.admin.mbg.model.UmsAdmin;
import com.zzb.test.admin.mbg.model.UmsPermission;

import java.util.List;

/**
 * 用户管理Service
 * Created by zzb on 2019/11/21 17:33
 */
public interface UmsAdminService {
    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    UmsAdmin getAdminByUsername(String username);

    /**
     * 用户注册
     * @param umsAdminParam
     * @return
     */
    UmsAdmin register(UmsAdmin umsAdminParam);

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    String login(String username,String password);

    /**
     * 根据用户id查询用户权限
     * @param adminId
     * @return
     */
    List<UmsPermission> getPermissionList(Long adminId);
}
