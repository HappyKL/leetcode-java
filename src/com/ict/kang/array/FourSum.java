package com.ict.kang.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums==null || nums.length < 4) return result;
        Arrays.sort(nums);

        for(int i =0;i<nums.length - 3;i++){
            if(i-1>=0&& nums[i] == nums[i-1]) continue;

            for(int j = i+ 1;j<nums.length - 2;j++){
                if(j-1 >=i+1 && nums[j] == nums[j-1] ) continue;

                int x = j+1 ,y= nums.length - 1;
                while(x < y){
                    int sum = nums[i] + nums[j] + nums[x] + nums[y];
                    if(sum > target) {
                        y --;
                    }else if(sum<target){
                        x ++;
                    }else{
                        result.add(Arrays.asList(nums[i],nums[j],nums[x],nums[y]));
                        while(++x<=nums.length-1 && nums[x] == nums[x-1]);
                        while(--y >=j+1 && nums[y] == nums[y+1]);
                    }
                }
            }
        }
        return result;

    }
}
