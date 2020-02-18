"""
Time Complexity : O(m+n) - where m is len(S) and n is the len(T)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this: none
"""

class Solution:
    def customSortString(self, S: str, T: str) -> str:
        result = ""
        if not S or not T or len(S) == 0 or len(T) == 0:
            return result
        
        charMap = {}
        
        for char in T:
            if char in charMap:
                charMap[char] += 1
            else:
                charMap[char] = 1
                
        for i in S:
            if i in charMap:
                result += i * charMap.get(i)
                charMap.pop(i, None)
        
        for k,v in charMap.items():
            result += k * v
                
        return result