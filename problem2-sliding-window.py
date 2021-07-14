class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        res = 0
        hashMap = {}
        slow = 0
        for i in range(len(s)):
            if s[i] not in hashMap:
                hashMap[s[i]] = i
            else:
                slow = max(slow, hashMap[s[i]]+1)
                hashMap[s[i]] = i
            res = max(res, (i - slow+1))
        return(res)

#Time complexity O(N)
#Space complexity O(1)