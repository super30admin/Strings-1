"""
Iterate iver chars if itss already seen shrink window
TC: O(n) n- Number of chars in given string
SP: O(m) m- number of unique chars
"""
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        start = 0
        seen = set()
        res = 0
        for end in range(len(s)):
            while s[end] in seen:
                seen.remove(s[start])
                start+=1
            seen.add(s[end])
            res = max(res, end-start+1)
        return res

