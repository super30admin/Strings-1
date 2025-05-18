# time complexity: O(n)
# space complexity: O(1)

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        longest = 0
        left = 0
        window = [0]*128

        for right in range(len(s)):
            idx = ord(s[right])
            window[idx] += 1

            while window[idx] == 2:
                window[ord(s[left])] -= 1
                left += 1
            longest = max(longest, right-left+1)
        return longest