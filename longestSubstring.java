class longestSubstring {

    // TC: O(n) SC:O(min(m,n))
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0, slow = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                slow = Math.max(slow, map.get(c));
            }
            max = Math.max(max, i - slow + 1);
            map.put(c, i + 1);
        }
        return max;
    }
}