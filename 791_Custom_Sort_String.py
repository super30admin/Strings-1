# Time Complexity : O(,n) [n=length of T]
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# Problem Approach
# 1. Count the freqency for each character in input string T
# 2. Traverse over the Strng S and for each charcter apped the char with frequency picked from map
# 3. Delete the char key from after for each iteration
# 4. Traverse over the map and add rest of the character in the res string
from collections import Counter
class Solution:
    def customSortString(self, S: str, T: str) -> str:
        if not T: return ''
        if not S: return T
        t_map = Counter(T)
        res = ''
        for char in S:
            if char in t_map:
                res += (char * t_map[char])
                del t_map[char]
        for key, value in t_map.items():
            res += (key * value)
        return res