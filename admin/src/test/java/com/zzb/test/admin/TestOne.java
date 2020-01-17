package com.zzb.test.admin;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

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
//        test1();    //集合的初始化
//        test2();    //键盘输入的两种方法1
//        test3();    //键盘输入的两种方法2
//        test4();    //Collections工具类常用方法
        test5();    //Arrays工具类常用方法

    }

    public static void test1(){
        logger.info("集合初始化反例:{}",mapNot);
        logger.info("集合初始化正例:{}",mapYes);
    }

    public static void test2(){
        Scanner scanner = new Scanner(System.in);
        logger.info("输入字符串,并按回车结束");
        String result = scanner.nextLine();
        scanner.close();
        logger.info("输入字符串结果 ===》{}", result);
    }

    public static void test3(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        logger.info("输入字符串,并按回车结束");
        try {
            String result = br.readLine();
            br.close();
            logger.info("输入字符串结果 ===》{}", result);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public static void test4(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(-1);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(-5);
        arrayList.add(7);
        arrayList.add(4);
        arrayList.add(-9);
        arrayList.add(-7);
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        arrayList2.add(-3);
        arrayList2.add(-5);
        arrayList2.add(7);

        logger.info("原始数组：===》{}", arrayList);

        //反转
        Collections.reverse(arrayList);
        logger.info("原始数组反转后：===》{}", arrayList);

        /**
         * 旋转，distance为正数时顺时针旋转，
         * 将后(distance%arrayList.size())个数移到前面，
         * distance为负数时，逆时针旋转，将前(distance%arrayList.size())个数移到后面
         */
        Collections.rotate(arrayList, 3);
        logger.info("反转后数组旋转后：===》{}", arrayList);

        /**
         * 随机排序
         */
        Collections.shuffle(arrayList);
        logger.info("原始数组随机排序：===》{}", arrayList);

        /**
         * 按自然排序的升序排序
         */
        Collections.sort(arrayList);
        logger.info("原始数组按升序排序：===》{}", arrayList);

        /**
         * 交换两个索引位置的元素
         */
        Collections.swap(arrayList, 2, 6);
        logger.info("升序后交换两个索引元素位置：===》{}", arrayList);

        /**
         * 定制排序
         */
        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        logger.info("定制排序后：===》{}", arrayList);

        /**
         * 根据元素的自然排序，返回最大元素
         */
        int maxElement = Collections.max(arrayList);
        logger.info("原始数组的最大元素：===》{}", maxElement);

        /**
         * 根据元素的自然排序，返回最小元素
         */
        int minElement = Collections.min(arrayList);
        logger.info("原始数组的最小元素：===》{}", minElement);

        /**
         * 替换
         */
        Collections.replaceAll(arrayList, -1, -3);
        Collections.replaceAll(arrayList, -7, 7);
        logger.info("替换后的数组：===》{}", arrayList);

        /**
         * 统计元素出现的次数
         */
        int frequency = Collections.frequency(arrayList, -3);
        logger.info("元素出现的次数：===》{}", frequency);

        /**
         * 统计list2按顺序在list中第一次出现的索引，找不到返回-1
         */
        int indexOfCount = Collections.indexOfSubList(arrayList, arrayList2);
        logger.info("arrayList2在arrayList中第一次出现的索引：===》{}", indexOfCount);

        /**
         * 对list进行二分查找，返回索引
         */
        Collections.sort(arrayList);
        int indexOf = Collections.binarySearch(arrayList, 3);
        logger.info("二分查找3出现的索引：===》{}", indexOf);
    }

    public static void test5(){
        int[] array = {1, 3, 2, 7, 6, 5, 4, 9};
        int[] paraArray = {1, 3, 2, 7, 6, 5, 4, 9};
        char[] charArray = { 'a', 'f', 'b', 'c', 'e', 'A', 'C', 'B' };
        String[] strs = { "abcdehg", "abcdefg", "abcdeag" };

        //按升序排列数组的指定范围(包左不包右)
        Arrays.sort(array, 2, 6);
        logger.info("2-6索引按升序排列数组：===》{}", array);

        //按照自然排序
        Arrays.sort(array);
        logger.info("原始数组排序后：===》{}", array);

        //按升序排列数组的指定范围(包左不包右)
        Arrays.parallelSort(paraArray, 2, 6);
        logger.info("2-6索引按升序排列数组：===》{}", paraArray);

        //按照自然排序
        Arrays.parallelSort(paraArray);
        logger.info("原始数组排序后：===》{}", paraArray);

        //按升序排列数组的指定范围(包左不包右)
        Arrays.parallelSort(charArray, 2, 6);
        logger.info("2-6索引按升序排列数组：===》{}", charArray);

        //按照自然排序
        Arrays.parallelSort(charArray);
        logger.info("原始数组排序后：===》{}", charArray);

        //按照自然排序
        Arrays.sort(strs);
        logger.info("原始数组排序后：===》{}", Arrays.toString(strs));

        /**
         * 排序后进行二分查找
         */
        Arrays.sort(charArray);
        int indexOf = Arrays.binarySearch(charArray, 'f');
        logger.info("二分查找索引：===》{}", indexOf);

        /**
         * 比较两个数组，元素数量相同并且每个索引位置元素相等
         */
        char[] a = null;
        char[] b = null;
        boolean nullIsEquals = Arrays.equals(a, b);
        boolean isEquals = Arrays.equals(array, paraArray);
        logger.info("两个非null数组是否相等：===》{}", isEquals);
        logger.info("两个null数组是否相等：===》{}", nullIsEquals);

        /**
         * 字符串转list
         */
        List<String> list =  Arrays.asList("zhaozhibin", "xihuan", "yangpei");
        logger.info("字符串转数组：===》{}", list);

    }
}
