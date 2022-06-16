/**
Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
class Solution 
{
    public int lengthOfLongestSubstring(String s) 
    {
    
        Map<Character, Integer> map = new HashMap<>();
        int maxResult = 0;
        int slow = 0;
        
        for(int fast =0; fast< s.length(); fast++)
        {
            char ch = s.charAt(fast);
            
            if(map.containsKey(ch))
            {
                int prevPosition = map.get(ch);
                if(prevPosition >= slow)
                {
                    slow = prevPosition + 1;
                }
                
            }
            
            int currentLength = fast - slow + 1;
            map.put(ch, fast);
            maxResult = Math.max(maxResult, currentLength);        
            
            
        }
        
        
        return maxResult;
    }
}