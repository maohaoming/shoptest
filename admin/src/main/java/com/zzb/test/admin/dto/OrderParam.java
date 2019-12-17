package com.zzb.test.admin.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * 生成订单时传入的参数
 * Created by zzb on 2019/12/17 14:57
 */
@Getter
@Setter
public class OrderParam {
    //收货地址id
    private Long memeberAddressId;
    //优惠券id
    private Long couponId;
    //使用的积分
    private Integer useIntegration;
    //支付的方式
    private Integer payType;

}
