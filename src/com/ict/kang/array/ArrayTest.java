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
        int[] a = { 5,6};
        int[] b = {1,2,3,4,7};
        MedianOfTwoSortedArrays medianOfTwoSortedArrays = new MedianOfTwoSortedArrays();
        System.out.println(medianOfTwoSortedArrays.findMedianSortedArrays(a, b));
    }

}
