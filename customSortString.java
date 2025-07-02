class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 0);
            }

            map.put(c, map.get(c) + 1);

        }
        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            if (map.containsKey(ch)) {
                int freq = map.get(ch);
                for (int k = 0; k < freq; k++) {
                    sb.append(ch);
                }
                map.remove(ch);
            }
        }
        for (char key : map.keySet()) {
            int freq = map.get(key);
            for (int k = 0; k < freq; k++) {
                sb.append(key);
            }
        }
        return sb.toString();
    }
}