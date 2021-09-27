class Solution:
    """
    TC - O(n)
    SC - O(1)
    """
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s:
            return 0
        hp = dict()
        slow = 0
        m = -1
        for i in range(len(s)):
            if s[i] in hp:
                slow = max(slow,hp[s[i]])
            hp[s[i]] = i+1
            m = max(m,i-slow+1)
        return m
        