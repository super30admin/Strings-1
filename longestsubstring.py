#Time Complexity : O(n)
#Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No



class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        maxv = 0
        sets = set()
        l = r = 0
        while r < len(s):
            if not s[r] in sets:
                sets.add(s[r])
            else:
                while s[l]!=s[r]:
                    sets.remove(s[l])
                    l += 1
                l += 1
            maxv = max(maxv, r-l+1)
            r += 1
        return maxv