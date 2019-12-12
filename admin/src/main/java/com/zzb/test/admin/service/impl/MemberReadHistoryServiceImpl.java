package com.zzb.test.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.zzb.test.admin.mongodb.document.MemberReadHistory;
import com.zzb.test.admin.mongodb.repository.MemberReadHistoryRepository;
import com.zzb.test.admin.service.MemberReadHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * MemberReadHistoryService的实现类
 * Created by zzb on 2019/12/10 10:46
 */
@Service
public class MemberReadHistoryServiceImpl implements MemberReadHistoryService {
    @Autowired
    private MemberReadHistoryRepository memberReadHistoryRepository;
    @Override
    public int create(MemberReadHistory memberReadHistory) {
        memberReadHistory.setId(null);
        memberReadHistory.setCreateTime(new Date());
        memberReadHistoryRepository.save(memberReadHistory);
        return 1;
    }

    @Override
    public int delete(List<String> ids) {
        List<MemberReadHistory> memberReadHistoryList = new ArrayList<>(ids.size());
        for (String id:ids) {
            MemberReadHistory mrh = new MemberReadHistory();
            mrh.setId(id);
            memberReadHistoryList.add(mrh);
        }
        memberReadHistoryRepository.deleteAll(memberReadHistoryList);
        return ids.size();
    }

    @Override
    public List<MemberReadHistory> listPage(Long memberId,Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return memberReadHistoryRepository.findByMemberIdOrderByCreateTimeDesc(memberId);
    }
}
