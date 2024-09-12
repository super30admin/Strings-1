// Time Complexity : O(n^2) where n is the length of the string
// Space Complexity : O(n) to store elements in the set
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Brute force solution by making all possible combinations of substrings and checking the length

class longestNonRepeatingSubstring_BruteForce {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0 || s.length() == 1) return s.length();
        int maxCount = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            HashSet<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            int count = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) {
                    count = j - i;
                    maxCount = Math.max(count, maxCount);
                    break;
                } else {
                    set.add(s.charAt(j));
                    count++;
                }
                maxCount = Math.max(count, maxCount);
            }
        }
        return maxCount;
    }
}