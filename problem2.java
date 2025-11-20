// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no

/*
 * We are using set and 2 pointers to solve the problem
 * keep slow at 0
 * start a loop and keep adding chars to set keep calulate max len by using i-slow+1
 * once you hit a dupliate start remove the chars for set until you have removed the dupliate one
 * we use slow pointer for this
 * 
 * in the end return max len found 
 * 
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int slow = 0;
        int mx = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (set.contains(ch)) {
                while (s.charAt(slow) != ch) {
                    set.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
            } else {
                set.add(ch);
            }
            mx = Math.max(mx, i - slow + 1);
        }
        return mx;
    }
}