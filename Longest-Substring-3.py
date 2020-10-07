# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

#store in set if present then increment start and remove the elemnt from the set
class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        start, end, mx = 0, 0, 0
        res = set()
        while end < len(s):
            if s[end] not in res:
                res.add(s[end])
                end += 1
                mx = max(mx, len(res))
            else:
                res.remove(s[start])
                start += 1
        return mx

