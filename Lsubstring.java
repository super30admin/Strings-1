// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Approach
/*
 * The slow pointer will be indicating the start of string and i the curr end of substring will check if this window has any repitions as we go forward using hashmap
 * if it does we update the start pointer till the first repition of char + 1 and update longest on each iterations
 */
import java.util.HashMap;
class Solution {
    public int lengthOfLongestSubstring(String s) {
     HashMap<Character, Integer> map = new HashMap<>();
     int start = 0;
     int longest = 0;
     for(int i = 0; i< s.length(); i++){
         char curr = s.charAt(i);
         if(map.containsKey(curr) ){
             int prev = map.get(curr);
             if(prev >= start && prev < i){
                 start = prev + 1;
             }
         }
         map.put(curr, i);
         longest = longest < i - start + 1 ? i - start + 1: longest;
     }

     return longest;

    }

}