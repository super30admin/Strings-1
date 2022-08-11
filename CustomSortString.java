import java.util.HashMap;

//Time Complexity: O(m+n) , m-length of string s, n-length of order
//Space Complexity: O(1)

class Solution {
    public String customSortString(String order, String s) {
        if (order == null || order.length() == 0)
            return s;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            int count = 0;
            if (map.containsKey(c)) {
                count = map.get(c); // count contains no. of occurrences of c to be added to the result string
                map.remove(c); // removing from hashmap to eliminate the chances of duplicates
            }
            while (count > 0) {
                sb.append(c);
                count--;
            }
        }

        for (char key : map.keySet()) { // adding the remaining elements to the result, which werent present in order.
            int cnt = map.get(key);
            while (cnt > 0) {
                sb.append(key);
                cnt--;
            }
        }

        return sb.toString();

    }
}