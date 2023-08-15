package org.example;

// Time Complexity : O(n)
// Space Complexity : O(1)  ->O(26) -> constant
// Did this code successfully run on Leetcode : Yes

import java.util.HashMap;

public class LengthOfLongestSubStringUsingHashMap {

    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        int len = 0;
        int left = 0;

        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            if(map.containsKey(c))
            {
                left = Math.max(left,map.get(c)+1);
            }
            map.put(c,i);
            len = Math.max(len,i-left+1);
        }
        return len;

    }
}
