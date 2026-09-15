//O(m+n) time complexity m is length of order n is length of string
// O(n) extra space for buillding string builder

class Solution {
    public String customSortString(String order, String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder result = new StringBuilder();

        // Build frequency map from s
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),
                    map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < order.length(); i++) {

            char ch = order.charAt(i);

            if (map.containsKey(ch)) {

                int count = map.get(ch);

                for (int j = 0; j < count; j++) {
                    result.append(ch);
                }

                map.remove(ch);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {

            char ch = entry.getKey();
            int count = entry.getValue();

            for (int i = 0; i < count; i++) {
                result.append(ch);
            }
        }

        return result.toString();
    }
}
