// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Set<Character> set = new HashSet();
        int i = 0, j = 0;
        int maxLength = 0;
        
        while(j < s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
                
                //calculates the maximum length if the substring had unique characters
                maxLength = Math.max(maxLength, set.size());
            }else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        
        return maxLength;
    
    }
}
