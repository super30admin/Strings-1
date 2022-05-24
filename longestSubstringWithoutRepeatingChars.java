/*
Problem: https://leetcode.com/problems/longest-substring-without-repeating-characters/
TC: O(n)
SC: O(1) -> we have only 26 characters
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        int windowStart = 0, windowEnd = 0;
        int maxLen = 0;
        int substrStart = 0;
        
        for (windowEnd = 0; windowEnd < s.length(); ++windowEnd) {
            if (charIndexMap.containsKey(s.charAt(windowEnd))) {
                // We need to check max here for the below case:
                // zabcdefgbz
                windowStart = Math.max(windowStart, charIndexMap.get(s.charAt(windowEnd)));
            }
            if (windowEnd - windowStart + 1 > maxLen) {
                maxLen = windowEnd - windowStart + 1;
                substrStart = windowStart;
            }
            // Put index + 1 of char because that's where the new string starts from.
            charIndexMap.put(s.charAt(windowEnd), windowEnd + 1);
        }
        System.out.println("Longest substring: " + s.substring(substrStart, substrStart + maxLen));
        return maxLen;
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        HashMap<Character, Integer> freqMap = new HashMap<>();
        int windowStart = 0, windowEnd = 0;
        int maxLen = 0, matches = 0;
        
        for (windowEnd = 0; windowEnd < s.length(); ++windowEnd) {
            char ch = s.charAt(windowEnd);
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            if (freqMap.get(ch) > 1) {
                ++matches;
            }
            
            while (matches > 0) {
                char outgoingCh = s.charAt(windowStart);
                freqMap.put(outgoingCh, freqMap.get(outgoingCh) - 1);
                if (freqMap.get(outgoingCh) > 0) {
                    --matches;
                }
                ++windowStart;
            }
            maxLen = Math.max(maxLen, windowEnd - windowStart + 1);
        }
        
        return maxLen;
    }
}