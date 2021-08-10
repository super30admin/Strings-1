
// Time Complexity : o(n)
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int lengthOfLongestSubstring(String s) {
       
        if(s.length()==0 || s==null)
            return 0;
        
         int slow=0;
         int fast=0;
         int maxLen=0;
        
        HashMap<Character,Integer> hm=new HashMap<>();
        
        while(fast<s.length())
        {
            
            if(hm.containsKey(s.charAt(fast)))
            {
                   slow=Math.max(slow,hm.get(s.charAt(fast)));
                
            }
        
             hm.put(s.charAt(fast),fast+1);
            maxLen=Math.max(maxLen,((fast-slow)+1));
            fast++;
        }
        
        return maxLen;
    }
}