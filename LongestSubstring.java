// Time Complexity : O(m^2)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0) return 0;
        int max = 0;
        int p = 0;
        int q = 0;
        HashSet<Character>  set = new HashSet<>();
        while(q<s.length() && p<s.length() )
        {
            if(!set.contains(s.charAt(q))) 
            {
               
                set.add(s.charAt(q++));
                
                max = Math.max(max,q-p);
            
                 
            }
            else
            {
                set.remove(s.charAt(p++));
            }
           
        }
        return max;
    }
}