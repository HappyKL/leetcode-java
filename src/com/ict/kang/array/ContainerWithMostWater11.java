package com.ict.kang.array;

/**
 * @author : likang
 * @version : 1.0
 * @date : 2019-09-10 23:20
 * @description :
 * @modified :
 */
public class ContainerWithMostWater11 {

    /**
     * @Date 2019-09-10 23:20
     * @Description 通过双指针，可以将暴力O(n)的复杂度将为O(1)
     * @param height
     * @Return int
     **/
    public int maxArea(int[] height) {
        int result = Math.min(height[0],height[height.length-1])*(height.length-1);
        int l=0,r=height.length-1;
        while(l<r){
            result = Math.max(result,Math.min(height[l],height[r])*(r-l));
            if(height[l] < height[r]){
                l++;
            }else{
                r--;
            }
        }
        return result;
    }
}
