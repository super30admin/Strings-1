# 791. Custom Sort String


# Code:

class Solution:
    def customSortString(self, S: str, T: str) -> str:
        mapping = collections.Counter(T)
        res = ""
        
        for i in S:
            if i in mapping:
                res+=(i*mapping[i])
                del mapping[i]
        
        for i in mapping:
            res+=(i*mapping[i])
        
        return res
        

# Time : O(len(T))
# Space: O(len(T))
# Accepted on Leetcode: Yes