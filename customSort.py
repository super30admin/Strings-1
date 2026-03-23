# Time Complexity : O(n + m) where n = len(s), m = len(order)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
# Approach: Use a hashmap to count frequency of characters in s.
# First, iterate through order and append characters in the given order
# based on their frequency. Remove them from the hashmap after use.
# Finally, append remaining characters (not in order) in any order.

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        cnt_mp = {}
        res = ""
        for i in s:
            if i in cnt_mp:
                cnt_mp[i] += 1
            else:
                cnt_mp[i] = 1
        
        for i in order:
            if i in cnt_mp:
                res += i * cnt_mp[i]
                del cnt_mp[i]
        
        for k,v in cnt_mp.items():
            res += k * v
        
        return res