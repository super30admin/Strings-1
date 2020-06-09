package com.ds.rani.string;

import java.util.HashMap;

/**
 *
 */
//Approach:start traversing String,and add character and its index in hashmap.
// As soon as I am getting character which is already exists in the map set maxLenght equals to map size,
// and start traversing the string from the next character of first  occurence of the  current character.clear map


//Time Complexity:o(n) where n is length of string
//Space Complexity:o(n)
public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap();
        int maxLength=0;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i)))
            {
                i=map.get(s.charAt(i));
                if(map.size()>maxLength)
                    maxLength=map.size();
                map.clear();
            }
            else
                map.put(s.charAt(i),i);

        }
        return Math.max(maxLength,map.size());
    }
}
