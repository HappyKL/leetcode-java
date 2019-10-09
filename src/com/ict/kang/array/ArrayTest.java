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
        int[] a = {-5,-4,-3,-2,-1,0,0,1,2,3,4,5};
        int b = 0;
        FourSum fourSum = new FourSum();
        System.out.println(fourSum.fourSum(a,b));
        //method(1);
    }

    static int count = 0;
    private static void method(int i) {

        System.out.println(count ++);
        method(1);
    }

}
