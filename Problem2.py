class Solution:
    # Time Complexity: O(n)
    # Space Complexity: O(1)
    def lengthOfLongestSubstring(self, s: str) -> int:
        result = 0
        slow = 0
        smap = set()
        for i in range(len(s)):
            if s[i] in smap:
                while s[slow] != s[i]:
                    smap.remove(s[slow])
                    slow += 1
                slow += 1
            smap.add(s[i])
            result = max(i - slow + 1, result)
        return result
