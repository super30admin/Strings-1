// Solution - Sliding Window Approach
// TC - O(n) - iterate over string once.
// SC - O(n) - HashMap space. Worst case all characters are unique.
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int res = 0;
        int curr = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!map.containsKey(ch)) {
                curr += 1;
                map.put(ch, i);

            } else {
                left = Math.max(left, map.get(ch));
                map.put(ch, i);
                curr = i - left;

            }
            if (res < curr) {
                res = curr;
            }

        }

        return res;

    }
}
