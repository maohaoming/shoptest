package com.zzb.test.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * 初始化静态集合
 * 对于集合类型的静态成员变量，不要使用集合实现来赋值，应该使用静态代码块赋值
 * Created by zzb on 2019/12/5 14:11
 */
public class TestOne {
    //反例
    private static Map<String,String> mapNot = new HashMap<String,String>(){
        {
            put("ad","不使用");
            put("adc","静态块赋值");
        }
    };
    //正例
    private static Map<String,String> mapYes = new HashMap<String,String>();
    static{
        mapYes.put("ad","使用");
        mapYes.put("adc","静态块赋值");
    };

    private static final Logger logger = LoggerFactory.getLogger(TestOne.class);

    public static void main(String[] args){

        logger.info("集合初始化反例:{}",mapNot);

        logger.info("集合初始化正例:{}",mapYes);
    }
}
