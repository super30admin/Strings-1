# Time Complexity : O(n), where n is the length of the input string
# Space Complexity : O(1)

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s:
            return 0

        char_set = set()
        max_length = 0
        start = 0
        end = 0

        while end < len(s):
            if s[end] not in char_set:
                char_set.add(s[end])
                end += 1
                max_length = max(max_length, len(char_set))
            else:
                char_set.remove(s[start])
                start += 1
        
        return max_length

# Examples
solution = Solution()

# Example 1
s1 = "abcabcbb"
print(solution.lengthOfLongestSubstring(s1))  # Output: 3

# Example 2
s2 = "bbbbb"
print(solution.lengthOfLongestSubstring(s2))  # Output: 1

# Example 3
s3 = "pwwkew"
print(solution.lengthOfLongestSubstring(s3))  # Output: 3