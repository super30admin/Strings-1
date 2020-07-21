"""
// Time Complexity : O(n), 
// Space Complexity : O(1), max 26
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
"""

from collections import defaultdict
class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        
        d = defaultdict(int) #to store index
        slow = fast = 0
        maxval = 0
        
        while fast < len(s):
            ch = s[fast]
            
            if ch in d:
                slow = max(slow, d[ch]) #will update slow if theres a repeat
            d[ch] = fast + 1
            
            maxval = max(maxval, fast - slow + 1) #keep track of max length
            fast += 1
            
        return maxval
        