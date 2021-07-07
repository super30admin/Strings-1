// Time Complexity : O(2N)
// Space Complexity : O(26)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public int lengthOfLongestSubstring(String s) {
        //base case
        if(s == null || s.length() == 0)
            return 0;
        
        HashSet<Character> set = new HashSet<>();
        int start=0, end=0, maxLen=0;
        
        while(end < s.length())
        {
            char ch = s.charAt(end);
            while(set.contains(ch))
            {
                set.remove(s.charAt(start));
                start++;
            }
            set.add(ch);
            maxLen=Math.max(maxLen, end-start+1);
            end++;
        }
        return maxLen;
    }
}
