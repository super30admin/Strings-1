// Time Complexity : o(n) whre n is length of string
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//sliding window approach
class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();

        int max = 0;
        int start = 0;
        int end = 0;
        int len = 0;

        while(end < s.length()){

            char ch = s.charAt(end);

            if(set.contains(ch)){
                while(s.charAt(start) != s.charAt(end)){
                    set.remove(s.charAt(start));
                    len--;
                    start++;
                }
                start++;
            }
            else{
                set.add(ch);
                len++;
            }
            max = Math.max(max, len);
            end++;
        }

        return max;
    }
}
