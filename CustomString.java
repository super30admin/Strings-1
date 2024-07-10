import java.util.*;

class Solution {
    public String customSortString(String order, String s) {
        if (s.length() == 0 || s == null) {
            return s;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            if (map.containsKey(c)) {
                int count = map.get(c);
                for (int j = 0; j < count; j++) {
                    sb.append(c);
                }
                map.remove(c);
            }
        }
        for (Character c : map.keySet()) {
            int count = map.get(c);
            for (int i = 0; i < count; i++) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String order = "cba";
        String s1 = "abcd";
        String result = s.customSortString(order, s1);
        System.out.println(result);
    }
}
