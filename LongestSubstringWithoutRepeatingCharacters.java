
// Time complexity : O(n)
// Space complexity : O(1)
import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int maxLen = lengthOfLongestSubstring(s);
        System.out.println(maxLen);
    }

    private static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        int slow = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (hmap.containsKey(c)) {
                slow = Math.max(slow, hmap.get(c) + 1);
            }
            hmap.put(c, i);
            max = Math.max(max, i - slow + 1);
        }

        return max;
    }
}
