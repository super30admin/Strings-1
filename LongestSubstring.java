// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

public class LongestSubstring {
    class Solution {
        public int lengthOfLongestSubstring(String s) {

            String temp = "";
            int maxLength = -1;

            if(s.length() == 0)
                return 0;

            if(s.length() == 1)
                return 1;

            for(char c : s.toCharArray()){
                String cur = String.valueOf(c);

                if(temp.contains(cur)){
                    temp = temp.substring(temp.indexOf(cur) + 1);
                }

                temp += cur;
                maxLength = Math.max(temp.length(), maxLength);
            }
            return maxLength;
        }
    }
}
