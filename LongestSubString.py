# Problem2 Longest Substring Without Repeating Characters(https://leetcode.com/problems/longest-substring-without-repeating-characters/)

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # using sliding window hashMap
        hashMap = dict()
        slow = 0
        maxLen = 0
        for i in range(len(s)):
            if s[i] in hashMap:
                slow = max(slow, hashMap[s[i]] + 1)
            hashMap[s[i]] = i
            maxLen = max(maxLen, i - slow + 1)
        return maxLen

# Time Complexity O(n)
# Space Complexity O(1)