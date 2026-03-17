/**
 * Uses frequency counting to reorder string s based on the custom order.
 * First place characters that appear in 'order' using their frequencies, then append remaining characters.
 * Time: O(n + m), Space: O(1) since freq array size is constant (26).
 */
public class CustomSortStrings {
    public String customSortString(String order, String s) {
        int[] freq = new int[26]; 
        StringBuilder result = new StringBuilder();

        // Count frequency of each character in s
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Place characters in the exact order specified by 'order'
        // Key idea: exhaust all occurrences of a character before moving to next
        for (char c : order.toCharArray()) {
            while (freq[c - 'a'] > 0) {
                result.append(c);
                freq[c - 'a']--;
            }
        }

        // Append remaining characters not present in 'order'
        // Invariant: only chars with non-zero freq are those not in 'order'
        for (char c : s.toCharArray()) {
            while (freq[c - 'a'] > 0) {
                result.append(c);
                freq[c - 'a']--;
            }
        }

        return result.toString();
    }
}