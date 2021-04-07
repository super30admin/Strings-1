// Time Complexity : O(n) n - length os String s
// Space Complexity : O(i)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int start =0;
        int res =0;
        HashSet<Character> map = new HashSet<>();
        for(int i=0;i<s.length();i++){
            while(map.contains(s.charAt(i))){
                map.remove(s.charAt(start++));  
            }
            map.add(s.charAt(i));
            res = Math.max(res,i-start+1);
        }
        return res;
    }
}
