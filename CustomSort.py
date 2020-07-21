-------------------------------- Custom Sort String ---------------------------------------------
# Time Complexity : O(T+S)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this : No
# 
# Here I took the frequency of the T string and iterated through s and if i find s[i] in counter, then I am appending all the characters of 
# T first with their frequencies and deleting that char from the dict. Later if any char in the dict, i will append all the characters
# with their frequencies return res


class Solution:
    def customSortString(self, S: str, T: str) -> str:
        if not S and not T or not T:
            return ''
        elif not S:
            return T
        d = Counter(T)
        res = ''
        for i in S:
            if i in d:
                res += (i*d[i])
                del d[i]
        for k,v in d.items():
            res+=(k*v)
        return res