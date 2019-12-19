package com.zzb.test.admin;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Junit的单元测试类
 * Created by zzb on 2019/12/18 11:02
 */
public class JunitTest {
    @Test
    public void test1(){
        System.out.println("这是一个单元测试类");
    }

    /**
     * 使用try-with-resources语句替代原来的try-catch-finally，能保证资源关闭
     */
    //反例
    @Test
    public void testFalse11(String fileName){
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        try{
            String line;
            br = new BufferedReader(new FileReader(fileName));
            while((line = br.readLine()) != null){
                sb.append(line);
            }
            System.out.println(sb);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (br != null) {
                try{
                    br.close();
                }catch (IOException ioe) {
                    System.out.println(ioe.getMessage());
                }
            }
        }
    }
    //正例
    @Test
    public void testTrue11(String fileName){
        StringBuilder sb = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;
            while((line = br.readLine()) != null){
                sb.append(line);
            }
            System.out.println(sb);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 用catch语句捕获异常后，什么也不进行处理，就让异常重新抛出，这跟不捕获异常的效果一样
     * 可以删除这些代码或者添加处理
     */
    //反例
    @Test
    public void testFalse17(String fileName) throws Exception{
        StringBuilder sb = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;
            while((line = br.readLine()) != null){
                sb.append(line);
            }
            System.out.println(sb);
        }catch (Exception e) {
            throw e;
        }
    }
    //正例
    @Test
    public void testTure17(String fileName) throws Exception{
        StringBuilder sb = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;
            while((line = br.readLine()) != null){
                sb.append(line);
            }
            System.out.println(sb);
        }
    }

}
