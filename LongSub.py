# Time Complexity: O(n) for iterating through each character in the string
# Space Complexity: O(n) for storing characters in set
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        charSet = set()
        max_len = 0
        left = 0

        for right in range(len(s)):
            while s[right] in charSet:
                charSet.remove(s[left])
                left +=1
            charSet.add(s[right])
            max_len = max(max_len, right - left + 1)
        return max_len