class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        """
        Approach:
        1. Use a sliding window with two pointers (`l` and `r`) to track the current window of non-repeating characters.
        2. Use a hash map (`charMap`) to store the latest index of each character seen.
        3. If a repeating character is found, move the left pointer `l` to one position after the last occurrence.

        Time Complexity: O(n), where n = length of the string `s`
        Space Complexity: O(n), for storing character indices in the hashmap
        """

        result = 0
        l = 0
        charMap = {}

        for r in range(len(s)):
            if s[r] in charMap:
                l = max(l, charMap[s[r]] + 1)

            charMap[s[r]] = r
            result = max(result, r - l + 1)

        return result
