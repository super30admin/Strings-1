# // Time Complexity : O(n) where n is the length of the string. 
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        chars = [0] * 128
        left = 0
        right = 0
        count = 0
        while(right<len(s)):
            chars[ord(s[right])] += 1
            while(chars[ord(s[right])] == 2):
                chars[ord(s[left])] -= 1
                left += 1
            count = max(count,right - left + 1)
            right += 1
        return count
