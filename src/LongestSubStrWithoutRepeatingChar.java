// Time Complexity : o(n)
// Space Complexity : o(1) - since we have 27 char, frequency hashmap will take constant space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

/**
 * 
 *  sliding window, start from 0 index, keep increasing window and also keep track of
    currently seen char and its index+1 in map, if we find repeating char ( and if index of repeat char if towards right of slow), reset slow to next index
    keep track of max length seen till now
   
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/

 */
class Solution {
    
  
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() ==0) return 0;
        Map<Character, Integer> map = new HashMap<>();
        
        int slow =0, fast = 0, maxLen = 0;
        
        while(fast < s.length()){
            char c = s.charAt(fast);
            
            if(map.containsKey(c)) {
                int index = map.get(c);
                
                if(index >=slow) {
                    slow = index;
                }
            }
            //put current char and index of its next char into map
            map.put(c, fast+1);
            maxLen = Math.max(maxLen, fast - slow + 1);
            fast++;
        }
        
        return maxLen;
    }
}