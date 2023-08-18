// Time Complexity : O(m + n) m: length of order and n: length of string
// Space Complexity : O(n) for hashmap
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
 * first we store the frequencies of characters in the map of string and print those characters as per the order and print the remaining at the end 
 */

import java.util.HashMap;
class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        String output = "";
        for(char c: s.toCharArray()){
            if(!map.containsKey(c)){
                map.put(c, 0);
            }
            map.put(c, map.get(c) + 1);
        }

        for(char c: order.toCharArray()){
            if(map.containsKey(c)){
                for(int i=0; i< map.get(c); i++){
                    output += c;
                }
                map.remove(c);
            }
        }

        for(char c: map.keySet()){
            
            for(int i=0; i<map.get(c); i++){
                output += c;
            }
        }
        return output;
    }
}