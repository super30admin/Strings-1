# Time Complexity : O(n)
# Space Complexity : O(k) where k = size of charset
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Use sliding window with hashmap.
# Expand window using pointer i and track characters in hashmap.
# If duplicate is found, shrink window from left (j) until duplicate is removed.
# Maintain the maximum window size (i - j + 1) with all unique characters.


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        cnt_mp = {}
        j = 0
        res = 0
        for i in range(len(s)):
            if s[i] in cnt_mp:
                while cnt_mp and s[i] in cnt_mp:
                    cnt_mp[s[j]] -= 1
                    if cnt_mp[s[j]] == 0:
                        del cnt_mp[s[j]]
                    j += 1
            cnt_mp[s[i]] = 1
            res = max(res,i-j+1)
        
        return res