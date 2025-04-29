// Time Complexity : O(m + n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

public class CustomSortString {
    public String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();

        for (Character ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (Character ch : order.toCharArray()) {
            int count = map.getOrDefault(ch, 0);
            while (count > 0) {
                sb.append(ch);
                count--;
            }
            map.remove(ch);
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Character ch = entry.getKey();
            int count = entry.getValue();
            while (count > 0) {
                sb.append(ch);
                count--;
            }
        }
        return sb.toString();
    }
}
