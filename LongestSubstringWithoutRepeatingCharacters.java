// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        boolean[] seen = new boolean[256];
        int i = 0;
        int j = 0;
        int sum = 0;
        int n = s.length();
        while(i<n && j<n){
            if(!seen[s.charAt(j)]){
                seen[s.charAt(j)] = true;
                sum = Math.max(sum, j-i+1);
                j++;
            } else {
                seen[s.charAt(i)] = false;
                i++;
            }
        }
        return sum;
    }
}
