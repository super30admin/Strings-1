// TC: O(n)
// SC: O(n)
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int slow, fast;
        slow = 0;
        fast = 0;
        while(fast < s.length()) {
            char c = s.charAt(fast);
            if(map.containsKey(c)) {
                slow = Math.max(slow, map.get(c));
            }
            count = Math.max(count, fast - slow + 1);
            map.put(c, fast + 1);
            fast++;
        }
        return count;
    }
}