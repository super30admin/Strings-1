# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        count = {}
        res = []
        for char in s:
            count[char] = count.get(char,0) + 1
        
        for char in order:
            if char in count:
                while count[char] > 0:
                    res.append(char)
                    count[char] = count.get(char,0) - 1
        
        for k,v in count.items():
            if v > 0:
                while count[k] > 0:
                    res.append(k)
                    count[k] = count.get(k,0) - 1
        
        return ''.join(res)