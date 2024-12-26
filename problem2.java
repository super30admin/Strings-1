import java.util.HashMap;
import java.util.HashSet;

public class problem2 {

    // Aproach 1 : sliding window technique
    // Time Complexity: 0(2n)
    // Space Complexity: 0(1)

    public int lengthOfLongestSubstring(String s) {

        int n = s.length();
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        int slow = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
//            set.add(c);
            if (set.contains(c)) {
                while (s.charAt(slow) != c) {
                    set.remove(s.charAt(slow));
                    slow++;
                }
                slow++;
            }
            set.add(c);
            max = Math.max(max, i - slow + 1);
        }
        return max;
    }

    // Aproach 2 : sliding window technique
    // Time Complexity: 0(n)
    // Space Complexity: 0(1)
    public int lengthOfLongestSubstring1(String s) {

        int n= s.length();
        int max=0, slow=0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                slow= Math.max(slow, map.get(c)+1);

            }
            map.put(c, i);
            max= Math.max(max, i - slow + 1);
        }
        return max;

    }
}