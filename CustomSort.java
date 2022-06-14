class Solution {

    /**
     * Create char and frequency map. Read order string and get all chars as per sorting and append in SB. Remove already element from map, iterate over remaining map elements.
     * TC: O(n)
     * SC: O(n)
     */

    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            if (map.containsKey(c)) {
                int count = map.get(c);
                while (count > 0) {
                    sb.append(c);
                    count--;
                }
                map.remove(c);
            }
        }

        for (char c : map.keySet()) {
            int count = map.get(c);
            while (count > 0) {
                sb.append(c);
                count--;
            }
        }

        return sb.toString();
    }
}
