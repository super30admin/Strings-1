/**
 * Custom Sort String
 *
 * Algorithm approach:
 * - Naive approach: iterate through `order` and for each character scan `s` to append matching characters.
 * - Then append characters in `s` that are not present in `order`.
 *
 * Time complexity: O(|order| * |s|) due to nested scanning (can be improved using counting/hashmap).
 * Space complexity: O(1) extra (result StringBuilder and constant extra variables) or O(k) for unique char counts.
 *
 * @see <a href="https://leetcode.com/problems/custom-sort-string/">LeetCode - Custom Sort String</a>
 */
public class CustomSortString {

    public String customSortString(String order, String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < order.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == order.charAt(i)) {
                    result.append(s.charAt(j));
                }
            }
        }
        for (int j = 0; j < s.length(); j++) {
            if (!order.contains(Character.toString(s.charAt(j)))) {
                result.append(s.charAt(j));
            }
        }
        return result.toString();
    }
}
