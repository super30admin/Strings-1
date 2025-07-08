class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> freqmap = new HashMap<>();

        // Use s.toCharArray() and getOrDefault()
        for (char st : s.toCharArray()) {
            freqmap.put(st, freqmap.getOrDefault(st, 0) + 1);
        }

        StringBuilder result = new StringBuilder();

        // 1. Append characters based on the 'order' string
        for (char ch : order.toCharArray()) { // Used 'ch' for clarity
            if (freqmap.containsKey(ch)) {
                int count = freqmap.get(ch);
                // Append the character 'count' times
                for (int i = 0; i < count; i++) {
                    result.append(ch);
                }
                // Remove the character from the map so it's not added again
                freqmap.remove(ch);
            }
        }

        // 2. Append all remaining characters that were not in 'order'
        for (char ch : freqmap.keySet()) {
            int count = freqmap.get(ch);
            for (int i = 0; i < count; i++) {
                result.append(ch);
            }
        }

        return result.toString();
    }
}

//
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxlength = 0;
        Set<Character> set = new HashSet<>();

        int left = 0;
        for (int right = 0; right < n; right++) {
            char rightchar = s.charAt(right);
            while (set.contains(rightchar)) {
                set.remove(s.charAt(left));
                left++;

            }
            set.add(rightchar);
            maxlength = Math.max(maxlength, right - left + 1);

        }
        return maxlength;

    }
}