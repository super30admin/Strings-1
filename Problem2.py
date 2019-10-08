# Time Complexity: O (n)(Where n is length of string)
# Space Complexity: O(m)(where m is longest substring) 
# Did this code successfully run on Leetcode : Yes
# Three line explanation of solution in plain english:
# - Instead of brute force sliding window can be used here. Initialize with start of window i as 0 and end of window j as 0.
# - If character at the end of window is in the dictionary than remove start of the window from dictionary and incraese left.
# - Else add right end of window to dictionary and move it by 1. Compare new window length with longest substring and update it.

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
#       Initialize dictionary and longest substring
        data = dict()
        longestSub = 0
        
#       Initialize two ends of window
        left = 0
        right = 0
        
#       Run while loop untill window does not cross the length of string
        while(left < len(s) and right < len(s)):
#           If right side of the windows is already in the dictionary than delete left side from the dictionary and increase it
            if s[right] in data:
                del data[s[left]]
                left += 1
#           Else add right side element to the dictionary and increase window from right. 
            else:
                data[s[right]] = 0
                right += 1
#               Update longest sub string
                longestSub = max(longestSub, right - left)
                
        return longestSub
                
            
