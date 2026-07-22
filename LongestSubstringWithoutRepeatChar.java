// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

//Description:
// - Use a sliding window defined by left and right.
// - Store the latest index of each character in a map.
//- When a duplicate appears, move left past its previous occurrence and update the maximum window length.

class LongestSubstringWithoutRepeatChar {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastIndexMap = new HashMap<>();
        int maxLength = 0;
        int left = 0, right = 0;
        while(right < s.length()) {
            if(lastIndexMap.containsKey(s.charAt(right))) {
                left = Math.max(left, lastIndexMap.get(s.charAt(right)) + 1);
            }

            lastIndexMap.put(s.charAt(right), right);
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }
}