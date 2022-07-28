// Time Complexity : O(n) n for length of string
// Space Complexity : O(1) Since we will store at most 26 alphabets and its indices at max;
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0) return 0;
        if(s.length()==1) return 1;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int slow = 0;
        int fast = 0;
        while(fast<s.length()){
            if(!map.containsKey(s.charAt(fast))){
                map.put(s.charAt(fast), fast+1);
                fast++;
            }
            else{
                max = Math.max(max, fast-slow);
                slow = Math.max(slow, map.get(s.charAt(fast)));
                map.put(s.charAt(fast), fast+1);
                fast++;
                //System.out.println(max);
            }
            //System.out.println(fast);
        }
        max = Math.max(max, fast-slow);
        return max;
    }

    public static void main(String [] args){
        LongestSubstring ls = new LongestSubstring();
        System.out.println(ls.lengthOfLongestSubstring("pwwkew"));
    }
}