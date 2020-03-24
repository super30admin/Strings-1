class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        freq_dict = {}
        left = 0
        max_len = 0

        for right in range(len(s)):
            freq_dict[s[right]] = freq_dict.get(s[right], 0) + 1

            while freq_dict[s[right]] >= 2:
                freq_dict[s[left]] -= 1
                left += 1

            max_len = max(max_len, right - left + 1)

        return max_len