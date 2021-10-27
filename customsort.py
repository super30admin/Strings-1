#Time Complexity : O(n)
#Space Complexity : O(1) 
# Did this code successfully run on Leetcode : Yes
#Any problem you faced while coding this : No



class Solution:
    def customSortString(self, order: str, s: str) -> str:
        n = len(s)
        hm = {}
        for i in s:
            if i in hm.keys():
                hm[i] += 1
            else:
                hm[i] = 1
        li = ''
        for i in order:
            if i in hm.keys():
                k = hm[i]
                while k!=0:
                    li += i
                    k -= 1
                del hm[i]
        for i in hm.keys():
            k = hm[i]
            while k!=0:
                li += i
                k -= 1
        return li