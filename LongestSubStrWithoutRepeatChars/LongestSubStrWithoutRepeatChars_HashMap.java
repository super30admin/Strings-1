/* Time Complexity : O(n) 
*   n - length of source string - s */
/* Space Complexity : O(26) ~ O(1) 
*   size of the hashmap */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//HashMap solution

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int sp = 0;
        int maxLen = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                //move slow pointer to the previous (index + 1) of char c
                sp = Math.max(sp, map.get(c) + 1);                
            }
            //update the new index of c in map
            map.put(c, i);
            maxLen = Math.max(maxLen, i - sp + 1);
        }
        return maxLen;
    }
}