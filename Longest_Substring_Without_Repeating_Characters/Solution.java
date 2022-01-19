// Time Complexity : O(length os s)
// Space Complexity : O(1) as only fix amount of char entries will go in hashmap irrespective of input size
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
/**
 * We use two pointer approach. One will iterate over s and other will keep track of valid start of substring
 * For each char we will check if it has occured before and it it lies between left and right
 * If yes, then we calculate length of substring formed so far and update result if it is less
 * Then we add / update entry of current char with value of r.
 * Once we have seen all chars of s again we update result if right - left > result.
 * Finally we return result as our ans
*/


class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int result = 0;
        int left = 0;
        int right = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(right < s.length()){
            char ch = s.charAt(right);
            if(map.containsKey(ch)&& map.get(ch) >= left){
                result = Math.max(result, right - left);
                left = map.get(ch) + 1;
            }
            map.put(ch, right);
            right++;
        }
        
        
        return Math.max(result, right - left);
    }
}