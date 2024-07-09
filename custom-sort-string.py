# Time Complexity : O(m+n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        result = ""
        s_map = dict()

        for i in s:
            s_map[i] = s_map.get(i,0)+1
        
        for i in order:
            if i in s_map:
                count = s_map.get(i, 0)
                result += i*count
                s_map.pop(i)
        
        if s_map:
            for key, value in s_map.items():
                result += key*value
        
        return result