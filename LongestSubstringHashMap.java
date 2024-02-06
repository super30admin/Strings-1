/*
* Approach:
*  1. Iterate over string using sliding window.
        start and end
    Maintain a hashmap with character and last seen index
* 
*  2. if character is found in hashmap,
        check if character last found in window(last found >= start)
* 
*  3. if inside window, update start to last found+1.
        everytime keep updating/inserting the last found index in hashmap.
        and keep track of max length.
* 
* 
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(n)
    n  - length of string
* 
* Space Complexity: O(26) === O(1)
* 
*/

import java.util.HashMap;

class LongestSubstringHashMap {
    public int lengthOfLongestSubstring(String s) {
        if(s.equals(""))
            return 0;

        HashMap<Character, Integer> hmap = new HashMap<>();

        int start = 0, end = 0;

        int maxlength = 0;

        while(end < s.length()){
            char ch = s.charAt(end);

            if(hmap.containsKey(ch) && hmap.get(ch) >= start){
                start = hmap.get(ch)+1;
            }

            hmap.put(ch, end);

            maxlength = Integer.max(maxlength,end-start+1);
            end++;
        }

        return maxlength;
    }
}