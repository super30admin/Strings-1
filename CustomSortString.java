package org.example;

import java.util.HashMap;

// Time Complexity : O(m)+O(26) -> O(m) -> m is the length of the string / O(26) for iterating over the order string
// Space Complexity : O(m)  -> StringBuilder occupies space for the length of the string
// Did this code successfully run on Leetcode : Yes

public class CustomSortString {

    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder result = new StringBuilder();
        for(int i=0; i<s.length(); i++)
        {
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for(int i=0; i<order.length(); i++)
        {
            char c = order.charAt(i);
            if(map.containsKey(c))
            {
                int freq = map.get(c);
                for(int j=0; j<freq; j++)
                {
                    result.append(c);
                }
                map.remove(c);
            }
        }

        for(char c : map.keySet())
        {
            int freq = map.get(c);
            for(int j=0; j<freq; j++)
            {
                result.append(c);
            }
        }

        return result.toString();

    }
}
