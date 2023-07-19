# Time Complexity : O(n) for each operation.
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : NA

# Approach is to use hashmap and create a frequency dictionary.

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        d={}
        for i in s:
            if i in d:
                d[i]+=1
            else:
                d[i]=1
        res=''
        for j in order:
            if j in d:
                for k in range(d[j]):  
                    res+=j
                del d[j]
        if d:
            for i in d:
                for k in range(d[i]):  
                    res+=i
        return res