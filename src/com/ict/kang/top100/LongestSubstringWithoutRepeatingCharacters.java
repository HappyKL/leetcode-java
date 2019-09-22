package com.ict.kang.top100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author : likang
 * @version : 1.0
 * @date : 2019-09-22 09:37
 * @description :
 * @modified :
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * @Date 2019-09-22 09:57
     * @Description 暴力 O(n^2)
     * @Return int
     **/
    public int lengthOfLongestSubstring1(String s) {
        int result = 0;
        Set<Character> setChar = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                Character c = s.charAt(j);
                if (!setChar.contains(c)) {
                    setChar.add(s.charAt(j));
                    result = result < setChar.size() ? setChar.size() : result;
                } else {
                    break;
                }
            }
            setChar.clear();
        }
        return result;
    }


    /**
     * @Date 2019-09-22 09:57
     * @Description 滑动窗口法 O(2n)
     * @Return int
     **/

    public int lengthOfLongestSubstring2(String s) {
        Set<Character> setChar = new HashSet<>();

        int i = 0, j = 0;
        int ans = 0;
        while (j < s.length()) {
            Character c = s.charAt(j);
            if (!setChar.contains(c)) {
                setChar.add(c);
                ans = ans < setChar.size() ? setChar.size() : ans;
                j++;
            } else {
                setChar.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    /**
     * @Date 2019-09-22 09:57
     * @Description 滑动窗口法优化 O(n)  记录重复元素的位置，从而避免冗余判断(hashMap实现)
     * @Return int
     **/

    public int lengthOfLongestSubstring3(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int ans = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            Character c = s.charAt(j);
            if (map.containsKey(c)) {
                i = Math.max(i, map.get(c) + 1);
            }
            map.put(c, j);
            ans = ans < j - i + 1 ? j - i + 1 : ans;
        }
        return ans;
    }


    /**
     * @Date 2019-09-22 09:57
     * @Description 滑动窗口法优化 O(n)  记录重复元素的位置，从而避免冗余判断(数组实现)
     * @Return int
     **/

    public int lengthOfLongestSubstring4(String s) {
        /*繁琐写法*/
//        int[] num = new int[128];
//        Arrays.fill(num, -1);
//        int ans = 0;
//        for (int i = 0, j = 0; j < s.length(); j++) {
//            char c = s.charAt(j);
//            if(num[c] != -1){
//                i = Math.max(i, num[c] + 1);
//            }
//            ans = ans < j - i + 1 ? j - i + 1 : ans;
//            num[c] = j;
//        }
//        return ans;

        /*简洁写法*/
        int[] num = new int[128];
        int ans = 0;
        for (int i = 0, j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            i = Math.max(i, num[c]);
            ans = ans < j - i + 1 ? j - i + 1 : ans;
            num[c] = j + 1;
        }
        return ans;
    }
}
