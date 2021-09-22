//https://leetcode.com/problems/longest-substring-without-repeating-characters/
/*
Time: O(n) where n = s.length()
Space: O(n) for the Set
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : None
*/
public class LongestSubstringWithoutRepeating {

    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<Character>();

        int apointer = 0; // apointer tracker is just to reduce the size of the set by 1.
        int bpointer = 0;
        int max = 0;
        // int start = 0, end = 0;

        while (bpointer < s.length()) {
            if (!set.contains(s.charAt(bpointer))) {
                set.add(s.charAt(bpointer));
                bpointer++;
                max = Math.max(max, set.size()); // store max at every point

            } else {
                set.remove(s.charAt(apointer));
                apointer++;
            }

        }
        return max;
    }

}
