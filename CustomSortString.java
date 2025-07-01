//time complexity-  O(Math.max(m, n)) where m is length of order and n is length of s
//space complexity- O(1)

import java.util.*;
public class CustomSortString {
    static String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder ans = new StringBuilder();
        for(int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            if(map.containsKey(c)) {
                for(int j = 0 ; j < map.get(c); j++) {
                    ans.append(c);
                }
                map.remove(c);
            }
        }

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                for(int j = 0 ; j < map.get(c); j++) {
                    ans.append(c);
                }
                map.remove(c);
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String order = "cba";
        String s = "afbecd";

        System.out.println("Custom sorted string according to order \"" + order + "\" in s \"" + s + "\" is : " + customSortString(order, s));
    }
}
