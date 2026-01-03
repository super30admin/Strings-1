"""
We use an optimised sliding window approach where in instead of incrementin the left pointer one by one untill the 'seen' condition turns false is avoided by jumping straight to 
the index + 1 of char at which duplicate is found.
TC is O(n) and SC is O(1) since map will only contain ascii values
"""

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        left = 0
        seen = {}
        ans = 0
        for right in range(len(s)):
            if s[right] in seen: #already in the window
                left = max(left, seen[s[right]] + 1) #take either the last occurence index + 1 or the left
            seen[s[right]] = right #update the most recent position of the character
            ans = max(ans, right - left + 1)
        return ans
 
            

        