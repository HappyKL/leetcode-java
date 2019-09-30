package com.ict.kang.top100;

/**
 * @author : likang
 * @version : 1.0
 * @date : 2019-09-26 13:59
 * @description :
 * @modified :
 */
public class LongestPalindromicSubstring {

    /**
     * @Date 2019-09-26 23:43
     * @Description 暴力 O(n^3)
     * @Return java.lang.String
     **/
    public String longestPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }
        String result = s.substring(0, 1);
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length() + 1; j++) {
                if (isPalindrome(s.substring(i, j))) {
                    if (j - i > result.length()) {
                        result = s.substring(i, j);
                    }
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @Date 2019-09-26 23:43
     * @Description 从中心向外扩展 O(n^2)
     * @Return java.lang.String
     **/
    public String longestPalindrome2(String s) {

        /** 代码冗余 **/
        if (s == null || s.length() == 0) {
            return "";
        }

        String result = s.substring(0, 1);
        for (int i = 1; i < s.length() - 1; i++) {
            int j, z;
            for (j = i - 1, z = i + 1; j >= 0 && z < s.length(); j--, z++) {
                if (s.charAt(j) != s.charAt(z)) {
                    break;
                }
            }
            if (z - j - 1 > result.length()) {
                result = s.substring(j + 1, z);
            }
        }

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i + 1) == s.charAt(i)) {
                int x = i - 1, y = i + 2;

                while (x >= 0 && y < s.length()) {
                    if (s.charAt(x) != s.charAt(y)) {
                        break;
                    }
                    x--;
                    y++;
                }
                if (y - x - 1 > result.length()) {
                    result = s.substring(x + 1, y);
                }
            }
        }
        return result;
    }


    /**
     * @Date 2019-09-27 00:15
     * @Description 动态规划实现 O(n^2)
     * @param s
     * @Return java.lang.String
     **/
    public String longestPalindrome3(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }
        int len = s.length();
        int start = 0, end = 1;
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        for (int i = 1; i < len; i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                dp[i - 1][i] = true;
                if (2 > end - start) {
                    start = i - 1;
                    end = i + 1;
                }
            } else {
                dp[i - 1][i] = false;
            }
        }
        for (int i = 2; i < len; i++) {
            for (int j = 0; j < len - i; j++) {
                if (dp[j][j + i] = dp[j + 1][j + i - 1] && s.charAt(j) == s.charAt(j + i)) {
                    if (i + 1 > end - start) {
                        start = j;
                        end = j + i + 1;
                    }
                }
            }
        }
        return s.substring(start, end);
    }


}
