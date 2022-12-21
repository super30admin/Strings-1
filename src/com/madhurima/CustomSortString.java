/*
 Time Complexity = O(m + n) where m is length of order and n is length of string
 Space Complexity = O(n) -> max entries in hashmap will be 26 distinct letters -> so this is constant space.
 However, we are using string builder -> which occupies size equivalent to length of string
 Did it run on LeetCode: yes

 */

package com.madhurima;

import java.util.HashMap;

public class CustomSortString {
    public String customSortString(String order, String s) {
        if(order == null || order.length() == 0 || s == null || s.length() == 0){
            return s;
        }

        HashMap<Character, Integer> hm = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(int i = 0; i < order.length(); i++){
            if(hm.containsKey(order.charAt(i))){
                for(int j = 0; j < hm.get(order.charAt(i)); j++){
                    sb.append(order.charAt(i));
                }
                hm.remove(order.charAt(i));
            }
        }

        for(char letter: hm.keySet()){
            for(int j = 0; j < hm.get(letter); j++){
                sb.append(letter);
            }
        }

        return sb.toString();

    }
}
