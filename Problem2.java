// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int ans = 0,left = 0, right = 0;
        for(right = 0; right < s.length();right++){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                ans = Math.max(ans,right-left+1);
            }
            else{
                while(set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                }
                set.add(s.charAt(right));
            }
        }
                

        
        return ans;
    }
}