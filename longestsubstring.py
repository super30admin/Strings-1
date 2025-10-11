# Time Complexity : O(n) where n is the length of the input string
# Space Complexity : O(1) as we are using a fixed size hashmap of 26 characters
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach:
# I am using a hashmap to store the last seen index of each character in the string.
# I will use two pointers, left and right, to represent the current window of the substring.
# I will iterate through the string using the right pointer and update the left pointer whenever I see a repeating character.
# I will also keep track of the maximum length of the substring seen so far by calculating the difference between the right and left pointers.
# In the end, I will return the maximum length of the substring.


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hashmap = {}
        left = 0
        maxy = 0
        for i in range(len(s)):
            if s[i] in hashmap:
                left = max(left,hashmap[s[i]] + 1)
            hashmap[s[i]] = i
            maxy = max(maxy, i - left + 1)
        return maxy