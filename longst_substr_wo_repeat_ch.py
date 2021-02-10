"""
Time Complexity : O(n)
Space Complexity : O(n)
"""
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s: return 0
        hashmap = {}
        low = 0
        high = 0
        maxlen = 0
        
        while high < len(s):
            if s[high] in hashmap:
                # Incase of "abba", low shouldn't go back; So max()
                low = max(low, hashmap[s[high]] + 1)
            
            hashmap[s[high]] = high     # Update repeat char index.
            high += 1
            maxlen = max(maxlen, high-low)
            
        return maxlen