"""
Leetcode: https://leetcode.com/problems/longest-substring-without-repeating-characters/

Approach: Sliding window
1. Use hashmap to store unique characters as key and its index as value.
2. Start and end pointers will start from index 0
3. Iterate while end is less than length
4. Keep track of the max length of the substring seen so far
6. If the current character exists in hashmap then our start pointer will move to the next index (of the last occurrence of this character)
7. Return the longest substring length

Time Complexity: O(n)
Space Complexity: O(n) for hashmap
"""


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # base case
        if not s or len(s) is 0:
            return 0

        # initialize
        start = 0
        end = 0
        char_map = {}
        result = 0

        # iterate through input string
        while end < len(s):
            # if duplicate exists, set start pointer to max of end or start
            if s[end] in char_map:
                start = max(char_map[s[end]], start)

            result = max(result, end - start + 1)

            char_map[s[end]] = end + 1
            end += 1

        return result

