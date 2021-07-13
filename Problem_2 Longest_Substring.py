# // Time Complexity : O(n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        charSet = set()
        res, left = 0, 0
        for i in range(len(s)):
            while s[i] in charSet:
                charSet.remove(s[left])
                # encounter repeat, point past
                left += 1
            charSet.add(s[i])
            res = max(res, i - left + 1)
        return res
