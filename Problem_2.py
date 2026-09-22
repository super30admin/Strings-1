# https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

# Time complexity: O(n) 
# Space complexity: O(min(m,n)) where n is lenght of array and m is size of alphabet
# Explanation: start from 0 with two counters, first keep expanding the right pointer till a max, and then increase left counter; return max value

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        chars = Counter()

        left = right = 0
        res = 0

        while right < len(s):
            r = s[right]
            chars[r] += 1

            while chars[r] > 1:
                l = s[left]
                chars[l] -= 1
                left += 1
            
            res = max(res, right - left + 1)
            right += 1

        return res
