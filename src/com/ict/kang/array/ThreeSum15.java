package com.ict.kang.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author : likang
 * @version : 1.0
 * @date : 2019-09-12 10:24
 * @description :
 * @modified :
 */
public class ThreeSum15 {

    /**
     * @Date 2019-09-12 10:32
     * @Description 使用双指针
     * @Return java.util.List<java.util.List < java.lang.Integer>>
     **/
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 3) {
            return result;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                return result;
            }
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = 0 - nums[i];
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (nums[j] + nums[k] > target) {
                    k--;
                } else if (nums[j] + nums[k] < target) {
                    j++;
                } else {
                    result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                    //去重
                    while(j<k && nums[j] == nums[j-1]) {
                        j++;
                    }
                    while(j<k && nums[k] == nums[k+1]){
                        k--;
                    }

                }
            }
        }
        return result;
    }
}
