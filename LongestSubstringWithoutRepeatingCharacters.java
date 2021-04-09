import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters {
    //brute force
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s == null) return 0;

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i ; j < s.length(); j++) {
                if (!repeat(s, i, j))
                    max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }
    private boolean repeat(String s, int i, int j) {
        HashSet<Character> set= new HashSet<>();
        for (int in = i; in <= j; in++) {
            char c = s.charAt(in);
            if (set.contains(c)) return true;
            set.add(c);
        }
        return false;
    }
}
