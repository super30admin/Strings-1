import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode 791. Custom Sort String
 * Link: https://leetcode.com/problems/custom-sort-string/description/
 */
public class CustomSortString {
    /**
     * create a frequency map of given string and later for each character in the order
     * get the frequency count in the map if present and add those many repeats of that character in result.
     * Once each character in order is processed remove that char from the map. At the end, map might be not empty
     * as there could be characters left which are not specified in the order - process them by repeating them by their
     * frequency count.
     *
     * TC: O(m + n) m length of the string and n length of the order which is 26 max so TC is O(m)
     * SC: O(m) in case each character in string s is unique which is maximum 26 entries in map so O(1) for map
     * but we are using stringbuilder as intermediate data structure so space complexity is O(m)
     */
    public String customSortString(String order, String s) {
        Map<Character, Integer> freq = new HashMap<>();
        StringBuilder result = new StringBuilder(s.length());

        for (char c: s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        for (char c: order.toCharArray()) {
            if (freq.containsKey(c)) {
                int repeat = freq.get(c);

                while(repeat != 0) {
                    result.append(c);
                    repeat--;
                }
                freq.remove(c);
            }
        }

        for(char c: freq.keySet()) {
            int repeat = freq.get(c);

            while(repeat != 0) {
                result.append(c);
                repeat--;
            }
        }

        return result.toString();
    }
}
