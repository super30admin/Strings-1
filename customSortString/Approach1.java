package customSortString;

import java.util.HashMap;

// Time Complexity: O(n) where n is the length of the string
// Space Complexity: O(1) as the hashmap will have at most 26 characters
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

//The idea here is to go iterate through the order string, and for each character in order string, we check for all the character in s string and add to result
//To perform search in O(1), we take a hashmap to store the frequency of a character
//Once we add all the characters from order string in the same order in the result, we add the remaining characters from s string to result


class Approach1 {
    public String customSortString(String order, String s) {

        if (order == null || order.length() == 0 || s == null || s.length() == 0) {
            return s;
        }

        int n = s.length();
        StringBuilder sb = new StringBuilder();

        HashMap<Character, Integer> map = new HashMap();

        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for(int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);

            if(map.containsKey(ch)) {
                int cnt = map.get(ch);
                while(cnt > 0) {
                    sb.append(ch);
                    cnt--;
                }

                map.remove(ch);
            }
        }

        // keys which are not there in order string
        for(Character ch : map.keySet()) {
            int cnt = map.get(ch);

            while(cnt > 0) {
                sb.append(ch);
                cnt--;
            }
        }

        return sb.toString();
    }
}