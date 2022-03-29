# Time Complexity: O(n)
# Space complexity : O(n)
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hashset = set()
        max_length = 0
        window_length = 0
        start = 0
        e = 0
        while (e != len(s)):
            if s[e] not in hashset:
                hashset.add(s[e])
                window_length += 1
                e += 1
            else:
                hashset.remove(s[start])
                window_length -= 1
                start += 1
            if window_length > max_length:
                max_length = window_length
        return max_length

