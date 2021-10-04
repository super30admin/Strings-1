// Time Complexity : O(n)
// Space Complexity : O(n)
// Idea here is to use Map to store character to its index, until the time a character repeats
// we keep adding the character to map and updating count of longest substring to maxcount
// as soon as we encounter existing the window length is set, map is updated with new index
// max count is updated with current max count and window length.
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null) return 0;
        int win = 0;
        int maxCount = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                win = Math.max(win, map.get(s.charAt(i))+1);
            }
            map.put(s.charAt(i), i);
            maxCount = Math.max(maxCount, i - win + 1);
        }
        return maxCount;
    }
}