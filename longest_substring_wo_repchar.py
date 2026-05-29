class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        slow = 0
        n = len(s)
        max_len = 0
        set_chars = set()

        for i in range(n):
            c = s[i]
            if c in set_chars:
                while s[slow] != c:
                    set_chars.remove(s[slow])
                    slow += 1
                slow += 1
            set_chars.add(c)
            max_len = max(max_len, i - slow + 1)

        return max_len

# Time: O(n)
# Space: O(1)