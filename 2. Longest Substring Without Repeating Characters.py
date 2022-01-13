class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # Time Complexity - O(n) where n is the length of the string
        # Space Complexity - O(1) as there are only 26 characters
        character_set = set()
        l = 0
        result = 0

        for r in range(len(s)):
            while s[r] in character_set:
                character_set.remove(s[l])
                l += 1
            character_set.add(s[r])
            result = max(result, r - l + 1)

        return result
