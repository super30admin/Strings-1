import java.util.*;

class Solution {
    // Sliding window with Hashset solution
    // Time complexity is O(2n)
    // Space complexity is O(1)
    // This solution is submitted on leetcode with zero errors
    public int lengthOfLongestSubstring(String s) {
        // Edge case
        if(s.length() == 0) return 0;
        
        HashSet<Character> set = new HashSet<>();
        int slow = 0;
        int res = -1;
        // i will be acting as fast pointer
        for(int i = 0; i<s.length();i++){
            char c = s.charAt(i);
            if(set.contains(c)){
                while(s.charAt(slow)!=c){
                    // First remove the slow and then move slow
                    set.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
            }
            set.add(c);
            int temp = i - slow +1;
            res = Math.max(temp,res);
        }
        return res;
    }
}

