# Time Complexity = O(n)
# Space Complexity = O(min(m,n))
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def lengthOfLongestSubstring(self, s):
        n = len(s)
        ans = 0
        
        # mp stores the current index of a character
        mp = {}

        i = 0
        
        # extend the range [i, j]
        for j in range(n):
            if s[j] in mp:
                i = max(mp[s[j]], i)

            ans = max(ans, j - i + 1)
            mp[s[j]] = j + 1

        return ans