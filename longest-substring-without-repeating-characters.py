# Time Complexity : O(n) - n is len(s)
# Space Complexity : o(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """

        map = {}
        max_len = 0
        j = 0

        for i in range(0,len(s)):
            if s[i] not in map:
                map[s[i]] = i
                # print(map)
            else:
                j = max(j,map[s[i]]+1)
                map[s[i]] = i
            max_len = max(max_len, i - j + 1)
        return max_len




