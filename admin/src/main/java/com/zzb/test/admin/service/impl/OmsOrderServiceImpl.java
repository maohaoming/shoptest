package com.zzb.test.admin.service.impl;

import com.zzb.test.admin.common.CancelOrderSender;
import com.zzb.test.admin.common.CommonResult;
import com.zzb.test.admin.dto.OrderParam;
import com.zzb.test.admin.service.OmsOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 订单管理接口实现类
 * Created by zzb on 2019/12/17 14:49
 */
@Service
public class OmsOrderServiceImpl implements OmsOrderService {
    private static Logger logger = LoggerFactory.getLogger(OmsOrderServiceImpl.class);
    @Autowired
    private CancelOrderSender cancelOrderSender;
    @Override
    public CommonResult generateOrder(OrderParam orderParam) {
        // TODO: 2019/12/17 下单生成订单
        logger.info("下单成功，获取到订单id：{}", 1L);
        //设置延迟发送时间，测试设置为30秒
        long delayTimes = 30*1000;
        //发送延迟消息
        cancelOrderSender.sendMessage(1L, delayTimes);
        return CommonResult.success("下单成功");
    }

    @Override
    public void cancelOrder(Long orderId) {
        // TODO: 2019/12/17 取消单个超时订单
        logger.info("根据orderId取消超时订单：{}", orderId);
    }

}
