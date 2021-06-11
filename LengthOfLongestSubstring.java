// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
    We save the position of the character in a Set. Once we have a repeat. We move the previous pointer to the previous occurance of the string.
*/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0; 
        int i = 0; 
        int j = 0;
        while (j < n) {
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i));
                i++;
            }
        }
        return ans;
    }
}