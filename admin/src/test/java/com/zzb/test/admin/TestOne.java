package com.zzb.test.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


/**
 * 由于某些方法要求参数在执行期间保持不变，因此将集合传递给自身可能会导致异常行为
 * Created by zzb on 2019/12/5 14:11
 */
public class TestOne {

    private static final Logger logger = LoggerFactory.getLogger(TestOne.class);
    public static void main(String[] args){
        String[] strs = new String[]{"1","2","3","4","5","6"};
        //反例
        List<String> listBad = new ArrayList<>();
        for (String str:strs) {
            listBad.add(str);
            logger.info("每次添加都要进行扩容");
        }

        //正例
        List<String> list = new ArrayList<>(strs.length);
        for (String str:strs) {
            listBad.add(str);
            logger.info("初始化扩容完成，此时添加不需要扩容");
        }

    }

}
