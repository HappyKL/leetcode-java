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
        int[] a = {4, 5};
        int[] b = {1,2,3,6};
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(a, b));
    }

}
