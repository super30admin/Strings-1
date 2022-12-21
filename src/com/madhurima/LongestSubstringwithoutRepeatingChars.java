/*
 Time Complexity = O(n)  n is length of string
 Space Complexity = O(1) -> max entries in hashmap will be 26 distinct letters -> so this is constant space.
 Did it run on LeetCode: yes

 */

package com.madhurima;

import java.util.HashMap;

public class LongestSubstringwithoutRepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }

        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                start = Math.max(start, map.get(c));
            }
            map.put(c, i+1); // as if match found, we need to move start ahead of the match
            max = Math.max(max, i - start + 1);
        }

        return max;


    }
}
