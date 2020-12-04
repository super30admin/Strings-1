"""
Time Complexity : O(n) 
Space Complexity : O(1) - as max 26 chars inside dictionary
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No


Your code here along with comments explaining your approach:
Here, we will keep a low pointer and make a dictionary. While traversing through the string, if the character 
not inside, the dictionary, we will just put it inside the dictionary with key as character and value as
its string index+1. We are adding this 1 as if in future we need to change position of low pointer, that
value from dictionary will be used. In case the key is already present inside the dictionary, we will
check for its value. If it is greater than low pointer, then only we will update the low pointer and update
maximum length if required. We also need to update value of that character inside dictionary.
"""


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        maxx = 0
        if not s:
            return maxx
        low = 0
        dictt = {}
        for i in range(len(s)):
            c = s[i]
            if c in dictt and low <= dictt[c]:
                low = dictt[c]
            dictt[c] = i+1
            maxx = max(maxx, i-low+1)
        return(maxx)
