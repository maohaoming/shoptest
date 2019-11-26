package com.zzb.test.admin.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


/**
 * 定时任务  订单超时自动取消并释放库存商品
 * Created by zzb on 2019/11/26 11:07
 */
@Component
public class OrderTimeOutCancelTask {

    private static final Logger logger = LoggerFactory.getLogger(OrderTimeOutCancelTask.class);

    // TODO: 2019/11/26 Seconds Minutes Hours DayofMonth Month DayofWeek
    @Scheduled(cron = "0 0/1 * ? * ?")
    public void cancelTimeOutOrder(){

        // TODO: 2019/11/26 从零点开始，每隔10分钟扫描一次，查询未支付订单
        logger.info("取消订单，并释放库存商品");
    }
}
