package com.zzb.test.admin.service;

import com.zzb.test.admin.mongodb.document.MemberReadHistory;

import java.util.List;

/**
 * 会员浏览记录管理Service
 * Created by zzb on 2019/12/10 10:42
 */
public interface MemberReadHistoryService {
    /**
     * 生成浏览记录
     * @param memberReadHistory
     * @return
     */
    int create(MemberReadHistory memberReadHistory);

    /**
     * 批量删除浏览记录
     * @param ids
     * @return
     */
    int delete(List<String> ids);

    /**
     * 分页获取用户浏览记录
     * @param memberId
     * @return
     */
    List<MemberReadHistory> listPage(Long memberId,Integer pageNum,Integer pageSize);
}
