// Time complexity: O(n^3)
// Space complexity: O(n)

// Brute force: find all substring and check if they have repeated characters

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String subs = s.substring(i, j+1);
                if (doesStringHaveRepeatedChar(subs)) {
                    max = Math.max(max, subs.length());
                }
            }
        }
        return max;
    }
    
    private boolean doesStringHaveRepeatedChar(String s) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
        }
        return s.length() == set.size();
    }
}