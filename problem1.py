# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : YES

# Any problem you faced while coding this : NO

from collections import Counter
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        res = ""
        freq_s = Counter(s)

        for char in order:
            if char in freq_s:
                res += char * freq_s[char]
            del freq_s[char]
        
        for char, times in freq_s.items():
            res += char * times
        
        return res