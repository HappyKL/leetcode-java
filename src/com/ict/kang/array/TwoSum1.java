package com.ict.kang.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : likang
 * @version : 1.0
 * @date : 2019-09-02 15:05
 * @description : leetcode 1 - 两数之和
 * @modified :
 */
public class TwoSum1 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> numsMap = new HashMap<>(5000);
        for(int i = 0;i<nums.length;i++){
            numsMap.put(nums[i],i);
        }
        for(int i = 0;i<nums.length;i++){
            int findElement = target - nums[i];
            if(numsMap.containsKey(findElement) && numsMap.get(findElement)!= i){
                int otherElementIndex = numsMap.get(findElement);
                result[0] = Math.min(i,otherElementIndex);
                result[1] = Math.max(i,otherElementIndex);
            }
        }
        return result;
    }
}
