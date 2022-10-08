#Time: O(n)
#Space: O(n)
#Program ran on leetcode successfully

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        if (s is None or len(s) == 0):
            return 0
        if (len(s) == 1):
            return 1
        charSet = set()
        slow = 0
        fast = 1
        maxLen = 0
        charSet.add(s[slow])
        
        while (fast < len(s)):
            c = s[fast]
            if (c in charSet):
                while (s[slow] != c):
                    charSet.remove(s[slow])
                    slow += 1
                slow += 1
            maxLen = max(maxLen, fast - slow + 1) 
            charSet.add(s[fast])
            fast += 1
        
        return maxLen