// Time Complexity : O(N + K) where N = s.length() and K = order.length()
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : NO

class CustomSortString_LC791 {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> freq = new HashMap<>();

        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : order.toCharArray()) {
            if (freq.containsKey(ch)) {
                while (freq.getOrDefault(ch, 0) > 0) {
                    sb.append(ch);
                    freq.put(ch, freq.get(ch) - 1);
                }
            }
            
        }

        // Iterate through freq and append remaining letters
        // This is necessary because some letters may not appear in `order`
        for (char ch : freq.keySet()) {
            int count = freq.get(ch);
            while (count > 0) {
                sb.append(ch);
                count--;
            }
        }

        return sb.toString();
    }
}