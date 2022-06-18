import java.util.*;

class Solution {
    // Sliding window with hashmap solution for loop
    // Time complexity is O(n)
    // Space complexity is O(1)
    // This solution is submitted on leetcode with zero errors
    public int lengthOfLongestSubstring(String s) {
        // Edge case
        if(s.length() == 0) return 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        int slow = 0;
        int res = -1;
        // i will be acting as fast pointer
        for(int i = 0; i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                slow = Math.max(map.get(c),slow);
            }
            map.put(c,i+1);
            int temp = i - slow +1;
            res = Math.max(temp,res);
        }
        return res;
    }
}

