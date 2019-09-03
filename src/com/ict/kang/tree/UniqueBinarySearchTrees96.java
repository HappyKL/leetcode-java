package com.ict.kang.tree;

/**
 * @author : likang
 * @version : 1.0
 * @date : 2019-09-03 11:10
 * @description : 不同的二叉搜索树
 * @modified :
 */
public class UniqueBinarySearchTrees96 {

    /**
     * @Date 2019-09-03 11:11
     * @Description 动态规划方法
     * @Return int
     **/
    public int numTrees1(int n) {
        int[] dp = new int[n + 1];
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[i] = 0;
        }
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[i - j] * dp[j - 1];
            }
        }
        return dp[n];
    }

    /**
     * @Date 2019-09-03 11:11
     * @Description 利用卡特兰数的递推公式
     * @Return
     **/
    public int numTrees2(int n) {

        long res = 1;
        for (int i = 1; i <= n; i++) {
            res = (4 * i - 2) * res / (i + 1);
        }
        return (int) res;
    }

}
