"""
TC/SC: O(m+n)/O(26)
"""
from collections import defaultdict
class Solution:
    def customSortString(self, order: str, str_: str) -> str:
        dict_ = defaultdict(int)
        hashset = set(list(order))
        res = []
        for s in str_:
            if s in hashset:
                dict_[s] += 1
            else:
                res.append(s)
        
        res1 = []
    
        for s in order:
            if s in dict_:
                temp = s*dict_[s]
                res1.append(temp)
        
        res = res + res1
        
        return "".join(res)
        
