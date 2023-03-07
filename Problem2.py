#Time Complexity:- O(m)
#Space Complexity :- O(1)

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hashMap = {}
        maxValue = 0
        slow = 0

        for i in range(len(s)):
            if s[i] in hashMap:
                slow = max(slow, hashMap[s[i]])
            hashMap[s[i]] = i+1
            maxValue = max(maxValue, i-slow+1)
        return maxValue