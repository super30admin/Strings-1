# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        s_map = dict()
        slow = 0
        maxVal = 0

        for i in range(len(s)):
            c = s[i]
            if c in s_map:
                slow = max(slow, s_map.get(c)+1)
            s_map[c] = i
            maxVal = max(maxVal, i-slow+1)
        return maxVal