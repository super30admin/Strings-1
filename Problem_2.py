# Time Complexity: O(n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        seen = {}
        l = 0
        out = 0
        for r in range(len(s)):
            if s[r] not in seen:
                out = max(out, (r - l + 1))
            else:
                if seen[s[r]] < l:
                    out = max(output, (r - l + 1))
                else:
                    l = (seen[s[r]] + 1)
            seen[s[r]] = r
        return out