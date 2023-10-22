
public class LongestSubstrWithoutRepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        java.util.HashMap<Character, Integer> map = new java.util.HashMap<>();
        int start = 0;
        int max = 1;
        for (int i = 0; i < s.length(); i++) {
            char single = s.charAt(i);
            if (map.containsKey(single)) {
                start = Math.max(start, map.get(single));

            }
            max = Math.max(max, i - start + 1);
            map.put(single, i + 1);

        }
        return max;
    }
}
