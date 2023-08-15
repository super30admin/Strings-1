package org.example;

import java.util.HashSet;
// Time Complexity : O(2n) -> O(n)
// Space Complexity : O(1)  ->O(26) -> constant
// Did this code successfully run on Leetcode : Yes

public class LengthOfLongestSubStringUsingHashSet {
    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();
        int len = 0;
        int left = 0;

        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            if(set.contains(c))
            {
                while(s.charAt(left)!= c){
                    set.remove(s.charAt(left));
                    left++;
                }
                left++;
            }
            set.add(c);
            len = Math.max(len, i-left+1);
        }
        return len;
    }
}
