# Time Complexity : O(n + m), n = len(s), m = len(order)
# Space Complexity : O(n + m), for count dictionary and output string
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Explanation:
# 1. Count occurrences of each character in s using a dictionary.
# 2. Append characters in the order specified by `order`.
# 3. Append remaining characters not in `order` in any order.

from collections import Counter

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        count = Counter(s)
        res = []
        
        # Add characters according to order
        for c in order:
            res.append(c * count[c])
            count[c] = 0
        
        # Add remaining characters not in order
        for c in count:
            res.append(c * count[c])
        
        return ''.join(res)