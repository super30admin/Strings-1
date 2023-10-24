# Time Complexity: O(n) where n is the length of s.
#  Space Complexity:  O(n)
#  Did this code successfully run on Leetcode : Yes
#  Any problem you faced while coding this : No

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        i = 0
        j = 0
        visited = set()
        res = 0
        while(j < len(s) ):
            ch = s[j]
            if ch not in visited:
                visited.add(ch)
            else:
                while ch in visited:
                    visited.remove(s[i])
                    i+= 1
                visited.add(ch)
            j += 1
            res = max(res, j-i)
        return res
