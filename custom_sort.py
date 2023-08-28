# m= len of order, n= len of s
# Time Complexity :O(M)
# Space Complexity :O(N)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        h={}
        temp=""
        for i in s:
            h[i]=h.get(i,0)+1

        for i in order:
            count=h.get(i,0)
            while(count):
                temp+=i
                count-=1
                h[i]-=1
        for i in h.keys():
            count=h[i]
            while(count):
                temp+=i
                count-=1
        return temp