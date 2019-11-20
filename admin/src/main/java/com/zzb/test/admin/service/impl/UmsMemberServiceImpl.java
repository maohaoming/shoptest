package com.zzb.test.admin.service.impl;

import com.zzb.test.admin.common.CommonResult;
import com.zzb.test.admin.service.RedisService;
import com.zzb.test.admin.service.UmsMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Random;

/**
 * UmsMemberService的实现类
 * Created by zzb on 2019/11/19 19:47
 */
@Service
@Transactional
public class UmsMemberServiceImpl implements UmsMemberService {

    @Autowired
    private RedisService redisService;
    @Value("${redis.key.prefix.authCode}")
    private String REDIS_KEY_PREFIX_AUTH_CODE;
    @Value("${redis.key.expire.authCode}")
    private Long AUTH_CODE_EXPIRE_SECONDS;

    @Override
    public String generateSmsCode(String telephone) {
        //生成随机的6位数验证码
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i=0;i<6;i++) {
            sb.append(random.nextInt(10));
        }
        //将生成的验证码存入redis缓存数据库
        redisService.set(REDIS_KEY_PREFIX_AUTH_CODE + telephone,sb.toString());
        //设置过期时间
        redisService.expire(REDIS_KEY_PREFIX_AUTH_CODE + telephone,AUTH_CODE_EXPIRE_SECONDS);
        return sb.toString();
    }

    @Override
    public CommonResult validSmsCode(String telephone, String smsCode) {
        //从redis缓存数据库中取出验证码
        String realSms = redisService.get(REDIS_KEY_PREFIX_AUTH_CODE + telephone);
        if (StringUtils.isEmpty(realSms)) {
            return CommonResult.failed("验证码已过期");
        }
        if (smsCode.equals(realSms)) {
            return CommonResult.success("校验成功");
        }
        return CommonResult.failed("输入验证码不正确");
    }
}
