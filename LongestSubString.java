// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// If repeating character is found, move slow pointer to prev found index +1
// this way ensures window of no repeating characters

import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int slow = 0; int max = 0;
        HashMap<Character,Integer> map = new HashMap<>(); //O(1)

        //O(2n)
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
               slow = Math.max(slow,map.get(s.charAt(i))+1);
            }

            map.put(s.charAt(i),i);
            max = Math.max(max, i-slow+1);
        }

        return max;
    }
}