// The time complexity of this implementation is O(n)
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String customSortString(String order, String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            if (freq.containsKey(c)) {
                int count = freq.get(c);
                while (count > 0) {
                    sb.append(c);
                    count--;
                }
                freq.remove(c);
            }
        }

        for (char c : s.toCharArray()) {
            if (freq.containsKey(c)) {
                int count = freq.get(c);
                while (count > 0) {
                    sb.append(c);
                    count--;
                }
                freq.remove(c);
            }
        }

        return sb.toString();
    }
    public static void main(String[] args) {
        Solution solution = new Solution();

        String order = "cba";
        String s = "abcd";
        String sorted = solution.customSortString(order, s);
        System.out.println("Sorted string: " + sorted); // Expected output: "dcba"

        order = "cbaf";
        s = "abcd";
        sorted = solution.customSortString(order, s);
        System.out.println("Sorted string: " + sorted); // Expected output: "cbad"
    }

}
