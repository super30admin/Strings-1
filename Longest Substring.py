# Time: O(n)| Space: O(n)
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        len_s = len(s)
        char_map = {}
        count = 0
        i = 0
        for j in range(len_s):
            ch = s[j]
            # if ch is seen, reset slow pointer
            if ch in char_map:
                i = max(char_map[ch], i)

            count = max(count, j - i + 1)
            char_map[ch] = j + 1
        return count