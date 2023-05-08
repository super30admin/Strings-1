# Time Complexity : O(n), where n is the length of the input string s
# Space Complexity : O(min(n, m)), where m is the size of the character set.
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        start = 0
        max_len = 0
        char_map = {}
        
        for end in range(len(s)):
            if s[end] in char_map:
                start = max(start, char_map[s[end]] + 1)
            
            char_map[s[end]] = end
            max_len = max(max_len, end - start + 1)
        
        return max_len