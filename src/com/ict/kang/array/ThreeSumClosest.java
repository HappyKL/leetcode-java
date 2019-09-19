package com.ict.kang.array;

import java.util.Arrays;

/**
 * @author : likang
 * @version : 1.0
 * @date : 2019-09-18 23:16
 * @description : 三数之和与目标值最接近
 * @modified :
 */
public class ThreeSumClosest {


    /**
     * @Date 2019-09-18 23:26
     * @Description 暴力 O(n^3)
     * @Return int
     **/
    public int threeSumClosest1(int[] nums, int target) {

        if (nums == null || nums.length < 3) {
            return -1;
        }

        int result = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    result =
                        Math.abs(result - target) < Math.abs(nums[i] + nums[j] + nums[k] - target)
                            ? result
                            : nums[i] + nums[j] + nums[k];
                }
            }
        }

        return result;
    }

    /**
     * @Date 2019-09-19 09:42
     * @Description 双指针 O(n^2)
     * @param nums
     * @param target
     * @Return int
     **/
    public int threeSumClosest2(int[] nums, int target) {

        if (nums == null || nums.length < 3) {
            return -1;
        }

        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if(nums[i] + nums[j] + nums[k] - target > 0){
                    if(Math.abs(result-target)>nums[i] + nums[j] + nums[k] - target){
                        result = nums[i] + nums[j] + nums[k];
                    }
                    k--;
                }else if(nums[i] + nums[j] + nums[k] - target < 0){
                    if(Math.abs(result-target)> Math.abs(nums[i] + nums[j] + nums[k] - target)){
                        result = nums[i] + nums[j] + nums[k];
                    }
                    j++;
                }else{
                    return target;
                }
            }
        }

        return result;


    }


}
