package com.zzb.test.admin.service;

import com.zzb.test.admin.common.CommonResult;

/**
 * 会员管理接口service
 * Created by zzb on 2019/11/19 19:44
 */
public interface UmsMemberService {
    /**
     * 根据手机生成手机验证码
     * @param telephone
     * @return
     */
    String generateSmsCode(String telephone);

    /**
     * 校验输入的手机验证码
     * @param telephone
     * @param smsCode
     * @return
     */
    CommonResult validSmsCode(String telephone, String smsCode);
}
