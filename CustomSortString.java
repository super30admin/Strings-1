import java.util.HashMap;

/*
## Problem1 
Custom Sort String (https://leetcode.com/problems/custom-sort-string/)

Time Complexity :   O (n) 
Space Complexity :  O (1) 
Did this code successfully run on Leetcode :    Yes (791. Custom Sort String)
Any problem you faced while coding this :       No
 */
// Input: order = "cba", s = "abcd"
// Output: "cbad"

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i=0; i< s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c,0)+1);
        }
        
        StringBuilder res = new StringBuilder();
        for(int i= 0; i< order.length(); i++){
            char c = order.charAt(i);
            if(map.containsKey(c)){
                int count = map.get(c);
                while(count>0){
                    res.append(c);
                    count--;
                }
            }
            map.remove(c);
        }
        // get remaining char in map
        for(Character c: map.keySet()){
            int count = map.get(c);
            while(count>0){
                res.append(c);
                count--;
            }
        }
        
        return res.toString();
    }
}