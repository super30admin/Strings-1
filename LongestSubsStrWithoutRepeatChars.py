"""
Time Complexity : O(n) where n if length of string
Space Complexity : O(1) hashmap would contain only limited strings
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
"""
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0:
            return 0
        mapD = {}
        maxi = float('-inf')
        slow = 0
        # We traverse through the string and with each character we put in the 
        # hashmap with an increased index and update my slow pointer to maximum value 
        # between current element in map and slow pointer. Otherwise if it already 
        # exists, we just update the value in map to current index where we found it. 
        # After that we update the maxi value to maximum of old maxi and diff of 
        # current index and slow pointer plus one
        for i in range(len(s)):
            if s[i] in mapD:
                slow = max(slow, mapD[s[i]])
            mapD[s[i]] = i + 1
            maxi = max(maxi, i - slow + 1)
        return maxi
            