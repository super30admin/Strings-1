// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this : No
 
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        if(s == null || s.length() == 0)
            return res;
        int i = 0, j = 0;
        int len = s.length();
        
        Set<Character> seen = new HashSet<>();
        while(i < len && j < len){
            if(!seen.contains(s.charAt(j))){
                seen.add(s.charAt(j++));
            }else{
                seen.remove(s.charAt(i++));
            }
            res = Math.max(res, j-i);
        }
        return res;
    }
}
