
/*
Time Complexity : O(1)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No

 */
class Solution {
    
    private Map<Character, Integer> position = new HashMap<>();
    
    
    public int lengthOfLongestSubstring(String s) {
        
        if(s == null || s.length() == 0) {
            return 0;
        }
        
        int maxLength = 0;
        
        for(int i=0, j= 0; i < s.length(); i++)
        {
            
            boolean alreadyExists = this.position.containsKey(s.charAt(i));
            
            if (alreadyExists) {
                
                int previousLocation = this.position.get(s.charAt(i));
                j = Math.max( j , previousLocation + 1);
            }
            
            int currentLength = i -j + 1;
            
            maxLength = 
                Math.max(maxLength, currentLength);
            
            this.position.put(s.charAt(i), i);
        }
        
        
        return maxLength;
        
    }
}