//time:O(N)
//space:O(N)
class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        int start = 0;
        int end = 0;
        int ans = Integer.MIN_VALUE;

        while (end < s.length()) {

            char ch = s.charAt(end);

            if (map.containsKey(ch)) {
                start = Math.max(start, map.get(ch));
            }
            map.put(ch, end + 1);
            ans = Math.max(ans, end - start + 1);

            end++;
        }
        return ans;
    }
}
