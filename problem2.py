# Space Complexity: O(n)
# Time Complexity: O(n)
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        l = len(s)
        m = 0
        if l <= 1: return l

        sett = set()
        left = 0
        for right in range(len(s)):
            ch = s[right]

            if ch in sett:
                while s[left] != ch:
                    sett.discard(s[left])
                    left+=1
                left+=1
            sett.add(ch)
            m = max(m, right - left + 1)

        return m



