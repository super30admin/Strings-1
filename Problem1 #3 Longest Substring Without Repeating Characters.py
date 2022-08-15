# Time Complexity: O(n)
# Space Complexity: O(1)

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if s is None:
            return 

        hashMap = {}
        slow = 0
        strMaxLength = 0

        for fast in range(len(s)):
            if s[fast] in hashMap:
                slow = max(slow, hashMap[s[fast]])
            hashMap[s[fast]] = fast + 1
            strMaxLength = max(strMaxLength, fast - slow + 1)

        return strMaxLength
