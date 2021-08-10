// Time Complexity : O(n), n = length of the string
// Space Complexity : O(1), string consists of 256 ASCII characters
// Did this code successfully run on Leetcode : Yes

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s == null)
            return 0;
        
        Map<Character, Integer> charMap = new HashMap<>();
        int maxLength = 0, slow = 0;
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(charMap.containsKey(ch))
                slow = Math.max(slow, charMap.get(ch));
            charMap.put(ch, i+1);
            maxLength = Math.max(maxLength, i-slow+1);
        }
        return maxLength;
    }
}