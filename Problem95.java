//Time : O(m+n)
//Space : O(m)
class Solution {
    public String customSortString(String order, String s) {
        // Step 1: Frequency map to count occurrences of characters in s
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: StringBuilder to build the result string
        StringBuilder result = new StringBuilder();

        // Step 3: Process each character in the 'order' string
        for (char c : order.toCharArray()) {
            if (freqMap.containsKey(c)) {
                int count = freqMap.get(c);
                // Append character c as many times as it appears in s
                for (int i = 0; i < count; i++) {
                    result.append(c);
                }
                // Remove the character from the map after processing
                freqMap.remove(c);
            }
        }

        // Step 4: Append remaining characters that are not in 'order'
        for (char c : s.toCharArray()) {
            if (freqMap.containsKey(c)) {
                result.append(c);
            }
        }

        return result.toString();
    }
}
