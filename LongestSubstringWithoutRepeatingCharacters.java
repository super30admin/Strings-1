// TC: O(s)
// SC: O(s)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int i, j, max;
        max = 0;
        i = 0;
        j = 0;
        while(j < s.length()) {
            char c = s.charAt(j);
            if(map.containsKey(c)) {
                i = Math.max(map.get(c) + 1, i);
            }
            map.put(c, j);
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;
    }
}