//TC: O(n)
//SC:O(1)

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = s.length();
        int max = 0;
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < l; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1); //to bypass the duplicate character
            }
            max = Math.max(max, i - left + 1);
            map.put(ch, i); // add characters to the hashset
        }
        return max;
    }
}