//Time Complexity : O(n), n -> Length of String 
// Space Complexity : O(1), No matter what the string length is, max length of map is constant
class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s == null || s.length() == 0) return 0;
        
        Map<Character, Integer> charMap = new HashMap<>();
        int maxLen = 0, slow = 0;
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            //update slow
            if(charMap.containsKey(ch)) {
                slow = Math.max(slow, charMap.get(ch));
            }
            //update index
            charMap.put(ch, i+1);
            maxLen = Math.max(maxLen, i-slow+1);
        }
        return maxLen;
    }
}