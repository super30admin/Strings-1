#Time complexity: O(N)
#Space complexity: O(1)
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        dic={}
        res=""
        for i in s:
            if i not in dic:
                dic[i]=0
            dic[i]+=1
        for j in order:
            if j in dic:
                count=dic[j]
                res+=j*count
                dic.pop(j)
        for i in dic:
            res+=i*dic[i]
        return res