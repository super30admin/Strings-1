# Time Complexity - O(N) where N = no.of characters
# Space Complexity - O(N) where N = no.of characters
# Approach : Sliding window 

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:

        if not s:
            return 0

        index = 0
        max_num = float("-inf")

        hashmap = {}

        for idx, char in enumerate(s):
            if char in hashmap:

                index = max(index, hashmap[char]) 

            hashmap[char] = idx + 1 
            max_num = max(max_num, idx - index +1)

        return max_num
