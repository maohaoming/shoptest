package com.zzb.test.admin.dao;

import com.zzb.test.admin.elasticsearch.document.EsProduct;

import java.util.List;

/**
 * Elasticsearch商品搜索dao
 * Created by zzb on 2019/12/4 11:20
 */
public interface EsProductDao {
    List<EsProduct> getProductEs(Long id);
}
