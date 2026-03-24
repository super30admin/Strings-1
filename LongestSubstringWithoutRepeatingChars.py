# Time Complexity : O(n)
# Space Complexity : O(1) since the character map is bounded by ASCII (at most 128 unique characters).
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach : We store the latest index of every character in a map.
# If we see a duplicate, we jump the slow pointer just past the last occurrence.
# Then we keep updating the length of the longest unique substring found.

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        index_map = {}
        slow, fast = 0, 0
        max_length = 0

        while fast < len(s):
            ch = s[fast]
            index = index_map.get(ch, None)
            if index is not None and slow <= index < fast:
                slow = index + 1

            max_length = max(max_length, fast - slow + 1)

            index_map[ch] = fast
            fast += 1

        return max_length
        