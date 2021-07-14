class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        slow = 0
        map = {}
        result = 0
        for i in range(len(s)):
            if s[i] in map.keys():
                slow = max(slow, map[s[i]])
            result = max(result, i - slow + 1)
            map[s[i]] = i + 1
        return result

# Time Complexity: O(n)
# Space Complexity: O(1)