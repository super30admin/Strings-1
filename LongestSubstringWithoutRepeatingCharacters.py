# Time Complexity : O(N)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Your code here along with comments explaining your approach
# Using Two Pointers. Intialize i and j to 0 and HashMap
# Iterate over the string and check if the character at index j is in HashMap if not add the character to HashMap and increment j
# Get the maxlength from j to i
# If the character is in HashMap remove the character at index i from HashMap and increment i
# Return maxlength


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s:
            return 0
        i = 0
        j = 0
        dict = {}
        maxlength = 0
        while j < len(s):
            if s[j] not in dict:
                dict[s[j]] = 1
                j += 1
                maxlength = max(maxlength, j - i)
            else:
                del dict[s[i]]
                i += 1
        return maxlength