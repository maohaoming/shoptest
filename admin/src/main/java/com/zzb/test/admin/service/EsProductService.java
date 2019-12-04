package com.zzb.test.admin.service;

import com.zzb.test.admin.elasticsearch.document.EsProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Elasticsearch商品搜索的Service
 * Created by zzb on 2019/12/4 11:00
 */
public interface EsProductService {
    /**
     * 从数据库中导入商品到ES
     * @return
     */
    int importAll();

    /**
     * 根据id删除商品
     * @param id
     */
    void delete(Long id);

    /**
     * 根据id创建商品
     * @param id
     * @return
     */
    EsProduct create(Long id);

    /**
     * 批量删除
     * @param ids
     */
    void deletes(List<Long> ids);

    /**
     * 根据关键字搜索
     * @param keyword
     * @param pageNum
     * @param pageSize
     * @return
     */
    Page<EsProduct> searchPage(String keyword, Integer pageNum,Integer pageSize);
}
