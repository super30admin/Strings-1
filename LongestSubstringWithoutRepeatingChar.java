// Time Complexity : O(n) n is the length of the given string
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

// Method 2 - Using HashMap to store character and index+1
// TC: O(n) slow pointer jumps directly to position taken from the hashmap
// SC: O(1)
// where n is the length of given input string

import java.util.HashMap;
import java.util.HashSet;

class LongestSubstringWithoutRepeatingChar {
    public int lengthOfLongestSubstring(String s) {
        //null check
        if(s == null || s.length() == 0) return 0;
        if(s.length() == 1) return 1;

        HashMap<Character, Integer> map = new HashMap<>();

        int slow = 0;
        int max = 0;

        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            //if character is already found in map
            if(map.containsKey(c)){
                //move or jump slow to the point whatever value u get from map
                slow = Math.max(slow,map.get(c));
            }
            //if not found in map
            //update the max value
            max = Math.max(max,i-slow+1);
            //put the new charcter in map with index+1
            map.put(c,i+1);
        }
        return max;
    }
}

//Method 1 - Using Set
//TC: O(2n) worst case slow and fast can traverse the whole string of length n
//SC: O(1)
// where n is the length of given input string

class Solution {
    public int lengthOfLongestSubstring(String s) {
        //null check
        if(s == null || s.length() == 0) return 0;
        if(s.length() == 1) return 1;

        int slow = 0;
        int fast = 1;
        int max = 0;

        HashSet<Character> set = new HashSet<>();

        //add the first character to set
        set.add(s.charAt(slow));

        while(fast < s.length()){
            char c = s.charAt(fast);
            if(set.contains(c)){
                //move slow pointer until you escape the repeated char
                while(s.charAt(slow) != c){
                    set.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
            }
            max = Math.max(max,fast-slow+1);
            set.add(c);
            fast++;
        }
        return max;
    }
}