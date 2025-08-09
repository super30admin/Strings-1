// TC: O(m + n) but given lower case bound, So we can ignore m
// SC: O(n) for the map
class Solution {
    public String customSortString(String order, String s) {

        if (order == null || order.length() == 0 || s == null || s.length() == 0) {
            return s;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder result = new StringBuilder();

        for (char c : order.toCharArray()) {
            if (map.containsKey(c)) {
                for(int i = 0; i < map.get(c); ++i) {
                    result.append(c);
                }

                map.remove(c);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            for (int i = 0; i < entry.getValue(); ++i) {
                result.append(entry.getKey());
            }
        }

        return result.toString();
    }
}