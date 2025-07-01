# class Solution:
#     def lengthOfLongestSubstring(self, s: str) -> int:
#         charset = set()
#         res = 0
#         l = 0
#         for r in range(len(s)):
#             while s[r] in charset:
#                 charset.remove(s[l])
#                 l+=1
#             charset.add(s[r])
#             res = max(res, r-l+1)
#         return res

# class Solution:
#     def lengthOfLongestSubstring(self, s: str) -> int:
#         charset = {}
#         res = 0
#         l = 0
#         for r in range(len(s)):
#             if s[r] in charset and charset[s[r]] >= l:
#                 l = charset[s[r]]+1
#             charset[s[r]] = r
#             res = max(res, r-l+1)
#         return res

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        charset = {}
        res = 0
        l = 0
        for r in range(len(s)):
            if s[r] in charset :
                l = max(l,charset[s[r]]+1)
            charset[s[r]] = r
            res = max(res, r-l+1)
        return res
        