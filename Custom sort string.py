// Time Complexity :O(n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        d={}
        out = ''
        for i in s:
            if i not in d:
                d[i]=1
            else:
                d[i]=d[i]+1
        for i in order:
            if i in d:
                for j in range(d[i]):
                    out = out+i
                del d[i]
        for key in d:
            for i in range(d[key]):
                out = out+key
        return out