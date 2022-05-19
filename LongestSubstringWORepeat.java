import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Time Complexity : O(n) n is length of s
// Space Complexity : O(n) at worst, set will have all n chars
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Your code here along with comments explaining your approach: sliding window. max the window as much as possible. keep track of the chars by adding them into set.

public class LongestSubstringWORepeat {
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;

        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, max = 0;

        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                j++;
                max = Math.max(set.size(), max);
            } else {
                set.remove(s.charAt(i));
                i++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbb"));
        System.out.println(lengthOfLongestSubstring("abcabc"));
        System.out.println(lengthOfLongestSubstring("pewwkew"));
        System.out.println(lengthOfLongestSubstring("au"));
        System.out.println(lengthOfLongestSubstring(" "));
    }
}
