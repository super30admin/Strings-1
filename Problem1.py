## Problem1 
# Custom Sort String (https://leetcode.com/problems/custom-sort-string/)
from collections import Counter

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        """
        Time Complexity: O(M + N) where n is the len of s and M is the len of order
        Space Complexity: O(1) auxiliary space
        """
        # 1. Create a frequency map automatically
        counts = Counter(s)
        res = []
        
        # 2. Append characters that are in `order`
        for c in order:
            if c in counts:
                # Multiply the character by its count and append to list
                res.append(c * counts[c])
                # Remove it so we know what's leftover
                del counts[c]
                
        # 3. Append the remaining characters that weren't in `order`
        for c, count in counts.items():
            res.append(c * count)
            
        # 4. Join the list into a single string efficiently
        return "".join(res)