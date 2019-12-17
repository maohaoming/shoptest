package com.zzb.test.admin.service;

import com.zzb.test.admin.common.CommonResult;
import com.zzb.test.admin.dto.OrderParam;
import org.springframework.transaction.annotation.Transactional;

/**
 * 订单管理接口
 * Created by zzb on 2019/12/17 14:47
 */
public interface OmsOrderService {
    /**
     * 下单生成订单
     * @param orderParam
     * @return
     */
    @Transactional
    CommonResult generateOrder(OrderParam orderParam);
    /**
     * 取消单个超时订单
     * @param orderId
     */
    @Transactional
    void cancelOrder(Long orderId);
}
