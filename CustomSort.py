"""
You are given two strings order and s. 
All the words of order are unique and were sorted in some custom order previously.

Permute the characters of s so that they match the order that order was sorted. 
More specifically, if a character x occurs before a character y in order, 
then x should occur before y in the permuted string.

Return any permutation of s that satisfies this property.
"""

# Time Complexity : O(m + n)
# Space Complexity : O(m)
# Did this code successfully run on VScode : Yes
# Any problem you faced while coding this : No

from typing import List

class Solution:
    
    def __init__(self):
        self.map1 = {}
        
    def customSortString(self, order: str, s: str) -> str:
        
        # null
        if not s or len(s) == 0:
            return ""

        # logic
        map1 = {}
        
        for c in s:
            
            if map1.get(c):
                map1[c] += 1
            else:
                map1[c] = 1

        result =""
        
        for i in order:
            
            if i in map1:
                
                while(map1[i]>0):
                    result += i
                    map1[i]-=1
                    
                del map1[i]

        if len(map1) > 0 :

            for j in map1.keys():

                while map1[j] > 0:
                    result += j
                    map1[j] -=1

        return result  
                


        
    
            if c in map1:
                


        