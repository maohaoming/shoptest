package com.zzb.test.admin.service;

import com.zzb.test.admin.mbg.model.PmsBrand;

import java.util.List;

/**
 * 品牌管理Service
 * Created by zzb on 2019/11/15 10:38
 */
public interface PmsBrandService {

    List<PmsBrand> getList(Integer pageNum,Integer pageSize);

    int insert(PmsBrand pmsBrand);

    int delete(Long id);

    int update(PmsBrand pmsBrand);
}
