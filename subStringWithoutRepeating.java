    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/longest-substring-without-repeating-characters/
    Time Complexity for operators : o(n) .. n is the length of the string
    Extra Space Complexity for operators : o(c) .. number of distinct characters
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : two for loops and (n3) time complexity
        # Optimized approach: 
                              
            # 1. 
                    A) This is optimized approach using SLiding Window.
                    B) Iterate thru string untile end reaches to s.length(). (i.e. end<s.length())
                    C) If character present in hashmap that means character is repeated which break the condition.
                    D) Once we encountered thee condition, move start to the max of start and 
                       the position of chracters which found again in hashmap.
                    E) In each straing characters, we put it in hashmap with its position + 1 value.
                    F) At the end calculate the max everytime and increment end by one.
                    G) Return the max value.
    */ 

class Solution {
    public int lengthOfLongestSubstring(String s) {
     
        if(s==null || s.length()==0)
            return 0;
        
        int start = 0;
        int end = 0;
        int max = Integer.MIN_VALUE;
        HashMap<Character, Integer> hm = new HashMap<>();
        
        while(end < s.length()){
            char ch = s.charAt(end);
            
            if(hm.containsKey(ch)){
                start = Math.max(start,hm.get(ch));
            }
            

            hm.put(ch,end+1);
            max = Math.max(max,end-start+1);
            
            end += 1;
        }
        
        return max;
    }
}