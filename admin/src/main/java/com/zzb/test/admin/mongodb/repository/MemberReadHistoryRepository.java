package com.zzb.test.admin.mongodb.repository;

import com.zzb.test.admin.mongodb.document.MemberReadHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * 操作Mongodb的Repository
 * Created by zzb on 2019/12/10 10:01
 */
public interface MemberReadHistoryRepository extends MongoRepository<MemberReadHistory,String> {
    /**
     * 根据会员id按时间倒序获取浏览记录
     * @param memberId
     * @return
     */
    List<MemberReadHistory> findByMemberIdOrderByCreateTimeDesc(Long memberId);
}
