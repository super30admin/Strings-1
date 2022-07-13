# Time Complexity : O(n)
# Space Complexity : O(26);
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        dictu = {}
        start = 0
        maxi = 0
        for end in range(len(s)):
            if s[end] in dictu:
                start = max(start, dictu[s[end]]+1)
            dictu[s[end]] = end
            maxi = max(maxi, abs(start - end) + 1)
        return maxi


# Using Hash-Set --> O(2*n)
# class Solution:
#     def lengthOfLongestSubstring(self, s: str) -> int:
#         dictu = set()
#         maxi = 0
#         slow = 0
#         fast = 0
#         while fast < len(s):
#             if s[fast] in dictu:
#                 while s[fast] in dictu:
#                     dictu.remove(s[slow])
#                     slow += 1
#             dictu.add(s[fast])
#             maxi = max(maxi, fast - slow + 1)
#             fast += 1
#         return maxi

# if sustrings are asked.
# class Solution:
#     def lengthOfLongestSubstring(self, s: str) -> int:
#         dictu = {}
#         start = 0
#         maxi = 0
#         result = set()
#         for end in range(len(s)):
#             if s[end] in dictu:
#                 start = max(start, dictu[s[end]]+1)
#             dictu[s[end]] = end
#             if abs(start-end)+1 == maxi:
#                 result.add(s[start:end+1])
#             elif abs(start-end)+1 > maxi:
#                 result.clear()
#                 result.add(s[start:end + 1])
#             maxi = max(maxi, abs(start - end) + 1)
#         return maxi