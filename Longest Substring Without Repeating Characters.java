// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l=0,r=0,len=0;

        while(r<s.length())
        {
            if(map.containsKey(s.charAt(r)))
            {
                l=Math.max(l,map.get(s.charAt(r))+1);
                
            }
            map.put(s.charAt(r),r);
            len=Math.max(len,r-l+1);
            r++;
        }
        return len;
    }
}