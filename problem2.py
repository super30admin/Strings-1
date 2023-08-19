# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0:
            return 0
        if len(s) == 1:
            return 1
        
        result = set()
        p1 = 0
        p2 = 0
        l = 0
        
        while p2 < len (s):
            if s[p2] not in result:
                result.add(s[p2])
                l = max(l, p2 - p1 + 1)
                p2 += 1
            else:
                result.remove(s[p1])
                p1 += 1
        
        return l