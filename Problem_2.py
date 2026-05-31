class Solution:
    def lengthOfLongestSubstring(self, s):
        ls = len(s)
        if ls == 0:
            return 0
        i = 0
        j = 0
        result = 1
        unique_chars = set()
        while j < ls:
            c = s[j]
            while i < ls and c in unique_chars:
                unique_chars.remove(s[i])
                i += 1

            if c not in unique_chars:
                unique_chars.add(c)
                result = max(result, j - i + 1)
                j += 1
        return result
