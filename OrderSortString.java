// Time Complexity : O(n) n is the length of the string s.
// Space Complexity : O(n) n is the length of the string s, for storing the frequency map.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


import java.util.*;
class Solution {
    public String customSortString(String order, String s) {
        StringBuilder result = new StringBuilder();
        Map<Character, Integer> freq = new HashMap<>();
        for(int i=0; i<s.length(); i++)
            freq.put(s.charAt(i), freq.getOrDefault(s.charAt(i), 0)+1);
        
        for(int i=0; i<order.length(); i++)
        {
            int num = freq.getOrDefault(order.charAt(i), 0);
            for(int j=0; j<num; j++)
                result.append(order.charAt(i));
            freq.remove(order.charAt(i));
        }

        for(char c : freq.keySet())
        {
            int num = freq.get(c);
            for(int i=0; i<num; i++)
                result.append(c);
        }
        return result.toString();
    }
}