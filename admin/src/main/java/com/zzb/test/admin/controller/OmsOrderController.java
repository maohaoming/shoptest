package com.zzb.test.admin.controller;

import com.zzb.test.admin.common.CommonResult;
import com.zzb.test.admin.dto.OrderParam;
import com.zzb.test.admin.service.OmsOrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 订单管理Controller
 * Created by zzb on 2019/12/17 15:10
 */
@Controller
@Api(tags = "OmsOrderController", description = "订单管理")
public class OmsOrderController {
    @Autowired
    private OmsOrderService omsOrderService;

    @ApiOperation("下单生成订单")
    @RequestMapping(value = "/admin/oms/generateOrder", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult generateOrder(@RequestBody OrderParam orderParam){
        return omsOrderService.generateOrder(orderParam);
    }
}
