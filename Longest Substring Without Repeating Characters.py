#HashMap
""""// Time Complexity : O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        slow = 0
        maximum = 0
        d = {}
        for i in range(len(s)):
            if s[i] in d:
                slow = max(slow, d[s[i]])
            d[s[i]] = i + 1
            maximum = max(maximum, i - slow + 1)
        return maximum

#HashSet
""""// Time Complexity : O(2n) --> O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
"""
# class Solution:
#     def lengthOfLongestSubstring(self, s: str) -> int:
#         if s is None or len(s) == 0:
#             return 0
#         if len(s) == 1:
#             return 1
#         d = set()
#         slow = 0
#         fast = 1
#         d.add(s[0])
#         result = 0
#
#         while fast < len(s):
#             if s[fast] in d:
#                 while s[slow] != s[fast]:
#                     d.remove(s[slow])
#                     slow += 1
#                 slow += 1
#             d.add(s[fast])
#             result = max(result, fast - slow + 1)
#             fast += 1
#         return result



# BruteForce
# class Solution:
#     def lengthOfLongestSubstring(self, s: str) -> int:
#         maxCount = 0
#         for i in range (len(s)):
#             subStr = s[i]
#             currentCount = 1
#             for j in range (i+1,len(s)):
#                 if(s[j] in subStr):
#                     break;
#                 subStr += s[j]
#                 currentCount+=1
#             maxCount = max(maxCount,currentCount)
#         return maxCount