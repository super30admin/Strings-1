"""
// Time Complexity : O(n) 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
Algorithm Explanation
Idea is to keep track of the non repeating char index and span/window of the string where the non repeating characters are present
In order to achieve that, we use map to store the non repeating characters and index + 1( which helps in getting next non repeating char in the string, in case of start of window)
Additionally, we use two pointers, start and end to keep track of the window 
Ultimately we keep the max of start and max of (start - end + 1) to get the maximum length of the string
"""
from collections import Counter,defaultdict
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        """
        Idea is to keep track of the non repeating char index 
        and span/window of the string where the non repeating characters are present
        In order to achieve that, we use map to store the non repeating characters and index + 1( which helps in getting next non repeating char in the string, in case of start of window)
        Additionally, we use two pointers, start and end to keep track of the window 
        Ultimately we keep the max of start and max of (start - end + 1) to get the maximum length of the string
        """
        n = len(s)

        #map for storing non repeating char and indexes
        chars = defaultdict(int)
        start,end = 0,0
        max_len = 0
        while end < n:
            #update start to keep maximum of current window
            start = max(start,chars[s[end]])
            
            #adding the char index to the chars with current end index + 1
            chars[s[end]] = end + 1

            #updating the maximum length
            max_len = max(max_len, end - start + 1)
            end+=1
        return max_len