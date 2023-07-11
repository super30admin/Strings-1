import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        int ans = 0;

        while (right < s.length()) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(map.get(s.charAt(right)), left); // 0 2
            }
            ans = Math.max(ans, right - left + 1);
            // We are storing character's index+1 so that when it reappears the left is
            // automatically to the next element i.e, correct positionn
            map.put(s.charAt(right), right + 1); // p1, w2, w3
            right++;
        }
        // System.out.println(map);
        return ans;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();

        String s = "pwwkew";

        int longestSubstringLength = obj.lengthOfLongestSubstring(s);

        System.out.println("Length of the Longest Substring: " + longestSubstringLength);
    }
}
