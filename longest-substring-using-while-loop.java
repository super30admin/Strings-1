import java.util.*;

class Solution {
    // Sliding window with hashmap solution while loop
    // Time complexity is O(n)
    // Space complexity is O(1)
    // This solution is submitted on leetcode with zero errors
    public int lengthOfLongestSubstring(String s) {
        // Edge case
        if(s.length() == 0) return 0;
        
        HashMap<Character, Integer> map = new HashMap<>();
        int slow = 0;
        int fast = 0;
        int res = -1;
        while(fast< s.length()){
            char c = s.charAt(fast);
            if(map.containsKey(c)){
                slow = Math.max(map.get(c),slow);
            }
            map.put(c,fast+1);
            fast++;
            int temp = fast - slow;
            res = Math.max(temp,res);
        }
        return res;
    }
}

