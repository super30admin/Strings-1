# TC : O(N)
# SC : O(min(N, M))


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        sub = ''
        res = ''
        for i in s:
            if i not in sub:
                sub += i
            else:
                if len(res) <= len(sub):
                    res = sub

                sub = sub.split(i)[-1] + i
        return max(len(res), len(sub))