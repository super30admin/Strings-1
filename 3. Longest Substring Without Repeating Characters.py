class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        left = 0
        right = 0
        max_l = 0
        hash_map = {}
        for char in s:
            if char in hash_map and hash_map[char] >= left:
                left = hash_map.get(char) + 1
            hash_map[char] = right
            max_l = max(max_l, right - left + 1)
            right += 1
        return max_l