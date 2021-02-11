# TC:O(N) 
# SC: O(N) set
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        charSet = set()
        res, left = 0, 0
        for i in range(len(s)):
            while s[i] in charSet:
                charSet.remove(s[left])
                # encounter repeat, point past
                left += 1
            charSet.add(s[i])
            res = max(res, i - left + 1)
        return res