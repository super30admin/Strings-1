'''
Time Complexity: O(n)
Space Complexity: O(k) - > K is the length of the largest substring with unique characters
Did this code successfully run on Leetcode : Yes
Explanation: Using Sliding window technique, check if we find the largest substring with unique characters.
'''
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0:
            return 0
        if len(s) == 1:
            return 1
        max1 = -100000
        dic = {}
        i = 0
        j = 0
        while i < len(s) and j < len(s):
            if s[j] not in dic.keys():
                dic[s[j]] = 1
                j = j + 1
                max1 = max(max1, j - i)
            else:
                del dic[s[i]]
                i = i + 1

        return max1