from collections import Counter
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        chars = Counter()
        left = 0
        right = 0
        res = 0

        while right < len(s):
            c = s[right]
            chars[c]+=1
            while chars[c] >1:
                l = s[left]
                chars[l]-=1
                left+=1
            res = max(res, right-left+1)
            right+=1
        return res
