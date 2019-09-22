package com.ict.kang.top100;

/**
 * @author : likang
 * @version : 1.0
 * @date : 2019-09-22 10:57
 * @description :
 * @modified :
 */
public class Test {

    public static void main(String[] args) {
        String s = "abcabcbb";
        LongestSubstringWithoutRepeatingCharacters f = new LongestSubstringWithoutRepeatingCharacters();
        int a = f.lengthOfLongestSubstring4(s);
        System.out.println(a);
    }

}
