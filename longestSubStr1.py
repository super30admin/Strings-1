#Time: O(n)
#Space: O(n)
#Program ran on leetcode successfully

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        window = {}
        slow = 0
        maxLength = 0
        for i in range(len(s)):
            c = s[i]
            if (c in window):
                slow = max(slow, window[c])
            maxLength = max(maxLength, i - slow +1)
            window[c] = i + 1
        
        return maxLength