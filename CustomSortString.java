class Solution {
    /* 
     * Time Complexity: O(N + M) where N is the length of 's' and M is the length of 'order'
     * Space Complexity: O(1) since the size of the map is bounded by the number of unique characters (at most 26)
     * 
     * The solution uses a HashMap to count the occurrences of each character in input string. 
     * It then constructs the result string by appending characters in the order specified by order, 
     * followed by any remaining characters that were not in order.
     */
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (Character ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (Character ch : order.toCharArray()) {
            if (map.containsKey(ch)) {
                for (int i = 0; i < map.get(ch); i++) {
                    sb.append(ch);
                }
                map.remove(ch);
            }
        }

        for (char ch : map.keySet()) {
            for (int i = 0; i < map.get(ch); i++) {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}