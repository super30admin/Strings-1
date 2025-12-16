import java.util.HashMap;

/**
 * Custom Sort String (counting approach)
 *
 * Algorithm approach:
 * - Count occurrences of each character in `s` using a HashMap.
 * - Iterate through `order` and append each character the counted number of times.
 * - Finally append any remaining characters from `s` that are not in `order`.
 *
 * Time complexity: O(n + m) where n = s.length(), m = order.length().
 * Space complexity: O(k) where k is the number of unique characters in `s` (for the map).
 *
 * @see <a href="https://leetcode.com/problems/custom-sort-string/">LeetCode - Custom Sort String</a>
 */
public class CustomSortString2 {

    public String customSortString(String order, String s) {
        StringBuilder result = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int j = 0; j < s.length(); j++) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
        }

        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            if(map.containsKey(ch)) {
                int count = map.get(ch);
                for (int j = 0; j < count; j++) {
                    result.append(ch);
                }
                map.remove(ch);
            }

        }

        for (char ch : map.keySet()) {
            int count = map.get(ch);
            for (int j = 0; j < count; j++) {
                result.append(ch);
            }
        }

        return result.toString();
    }
}
