// Time Complexity : O(N) N length of string. Iterating over the whole length of s. 
// Space Complexity : O(1) haset will have atmost 26 characters
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach:
//Used hashset for keeping count of characters. Use two pointers for window string.


class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s == null || s.length() == 0) return 0;
        
        HashSet<Character> set = new HashSet<>();
        
        int maxLen = 0;
        
        int start = 0, end = 0;
        
        while(end< s.length()){
           char ch = s.charAt(end);
            while(set.contains(ch)){
                set.remove(s.charAt(start));
                start++;
            }
            
            set.add(ch);
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }
        
        return maxLen;
    }
}