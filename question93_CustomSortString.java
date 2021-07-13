package Strings1;

import java.util.HashMap;

public class question93_CustomSortString {
    /* Created by palak on 7/12/2021 */

    /*
        Time Complexity: O(m + n)
        Space Complexity: O(n)
    */
    public static String customSortString(String order, String str) {
        StringBuilder result = new StringBuilder();
        if(str == null || str.length() == 0) return result.toString();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0 ; i < str.length() ; i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int i = 0 ; i < order.length() ; i++) {
            char c = order.charAt(i);
            if(map.containsKey(c)) {
                int count = map.get(c);
                while(count > 0) {
                    result.append(c);
                    count--;
                }
                map.remove(c); // O(1)
            }
        }
        for(char key: map.keySet()) {
            int count = map.get(key);
            while(count > 0) {
                result.append(key);
                count--;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String order = "cba";
        String str = "abcd";

        System.out.println(customSortString(order, str));
    }
}
