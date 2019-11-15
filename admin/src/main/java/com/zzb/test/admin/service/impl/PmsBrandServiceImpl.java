package com.zzb.test.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.zzb.test.admin.mbg.mapper.PmsBrandMapper;
import com.zzb.test.admin.mbg.model.PmsBrand;
import com.zzb.test.admin.service.PmsBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * PmsBrandService的实现类
 * Created by zzb on 2019/11/15 10:40
 */
@Service
@Transactional
public class PmsBrandServiceImpl implements PmsBrandService {

    @Autowired
    private PmsBrandMapper pmsBrandMapper;

    @Override
    public List<PmsBrand> getList(Integer pageNum,Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return pmsBrandMapper.selectByExample(null);
    }

    @Override
    public int insert(PmsBrand pmsBrand) {
        return pmsBrandMapper.insert(pmsBrand);
    }

    @Override
    public int delete(Long id) {
        return pmsBrandMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(PmsBrand pmsBrand) {
        return pmsBrandMapper.updateByPrimaryKeySelective(pmsBrand);
    }
}
