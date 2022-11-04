// Time Complexity : O(n)
// Space COmplexity : O(1) -> Since maximum 26 or 52 characters for keys of hashmap
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s ==null || s.length() == 0) return 0;

        HashMap<Character, Integer> map = new HashMap<>();
        int slow = 0;
        int max = 0;

        for (int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                slow = Math.max(slow, map.get(c));
            }
            map.put(c, i+1);
            max = Math.max(max, i - slow + 1);
        }

        return max;
    }
}
