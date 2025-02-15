# Time complexity - O(n)
# Space complexity - O(26) -> O(1)

# Approach - Go through the string, check if char is already in hashmap and is 
# within the window, update the slow pointer right after the char index, update 
# the char index and compute max length observed so far.

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if s is None or len(s) == 0:
            return 0
        if len(s) == 1:
            return 1
        Max = 0
        hashmap = dict()
        slow = 0

        for i in range(len(s)):
            c = s[i]
            if c in hashmap and hashmap[c] >= slow:
                slow = hashmap[c] + 1
            hashmap[c] = i
            Max = max(Max, i - slow + 1)
        
        return Max