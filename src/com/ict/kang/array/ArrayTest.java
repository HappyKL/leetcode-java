package com.ict.kang.array;

/**
 * @author : likang
 * @version : 1.0
 * @date : 2019-09-02 15:05
 * @description : 测试array
 * @modified :
 */
public class ArrayTest {

    public static void main(String[] args) {
//        int[] a = {1,3};
//        int[] b = {2};
//        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
//        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(a, b));
        method(1);
    }

    static int count = 0;
    private static void method(int i) {

        System.out.println(count ++);
        method(1);
    }

}
