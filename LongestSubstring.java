// the time complexity of this implementation is O(1)
import java.util.HashSet;
import java.util.Set;

class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        Set<Character> set = new HashSet<>();
        int left = 0, right = 0, maxLength = 0;

        while (right < n) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }

        return maxLength;
    }
    public static void main(String[] args) {
        LongestSubstring solution = new LongestSubstring();
        String s = "abcabcbb";
        int length = solution.lengthOfLongestSubstring(s);
        System.out.println("Length of longest substring in " + s + " is " + length);
    }
}
