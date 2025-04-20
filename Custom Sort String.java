class Solution {
    // TC: O(n + m) where n = order.length(), m = s.length()
    // SC: O(1) since only constant space (26 characters)
    public String customSortString(String order, String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        StringBuilder result = new StringBuilder();

        // Add characters in order
        for (char c : order.toCharArray()) {
            while (count[c - 'a']-- > 0) {
                result.append(c);
            }
        }

        // Add remaining characters
        for (char c = 'a'; c <= 'z'; c++) {
            while (count[c - 'a']-- > 0) {
                result.append(c);
            }
        }

        return result.toString();
    }
}
