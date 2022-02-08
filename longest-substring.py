# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Yes, a little

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:

        maxv = 0
        sets = set()
        left = 0
        right = 0

        while right < len(s):

            if not s[right] in sets:
                sets.add(s[right])

            else:
                while s[left] != s[right]:
                    sets.remove(s[left])
                    left = left + 1
                left = left + 1

            maxv = max(maxv, right - left + 1)
            right = right + 1
        return maxv
