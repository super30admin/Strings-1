# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


#save a map for the count and iterate over the map then according to the order of order string iterate and append to a string
class Solution:
    def customSortString(self, order: str, str: str) -> str:
        if len(str) < 2:
            return str
        
        a = {}
        
        for i in str:
            if i not in a:
                a[i] = 0
            a[i] += 1
        out = ""
        for i in order:
            if i in a:
                for j in range(a[i]):
                    out += i
                del a[i]
        for i in a:
            for j in range(a[i]):
                out += i
        return out
                