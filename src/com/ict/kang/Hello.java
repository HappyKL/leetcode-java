package com.ict.kang;

import com.ict.kang.array.TwoSum1;

import java.util.Scanner;

/**
 * @author : likang
 * @version : 1.0
 * @date : 2019-09-02 15:05
 * @description : 随意测试
 * @modified :
 */
public class Hello {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.next();
        line = line.substring(1, line.length() - 1);
        String[] arrayString = line.split(",");
        int[] array = new int[arrayString.length];
        for (int i = 0; i < arrayString.length; i++) {
            array[i] = Integer.valueOf(arrayString[i]);
        }
        int target = scanner.nextInt();

        TwoSum1 twoSum1 = new TwoSum1();
        int[] result = twoSum1.twoSum(array, target);
        System.out.println("[" + result[0] + "," + result[1] + "]");
    }
}
