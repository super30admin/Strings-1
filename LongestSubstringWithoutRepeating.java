class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        Set<Character> set = new HashSet<>();
        int maximum = 0;

        while (start < s.length() && end < s.length()) {
            Character character = s.charAt(end);

            while (set.contains(character)) {
                set.remove(s.charAt(start++));
            }
            set.add(s[end]);
            maximum = Math.max(maximum, set.size());
            end++
        }
        return maximum;
    }
}