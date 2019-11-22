package com.zzb.test.admin.dao;

import com.zzb.test.admin.mbg.model.UmsPermission;

import java.util.List;

/**
 * 用户与角色关系自定义dao
 * Created by zzb on 2019/11/21 18:00
 */
public interface UmsAdminRoleRelationDao {
    /**
     * 获取用户的所有权限
     * @param adminId
     * @return
     */
    List<UmsPermission> getPermissionList(Long adminId);
}
