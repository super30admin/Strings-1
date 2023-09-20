class Solution:
    def customSortString(self, order: str, s: str) -> str:
        dic={}
        dic1={}
        rem=""
        lis=[]
        for i in range(len(order)):
            dic[order[i]]=i
        for i in dic:
            dic1[dic[i]]=i
        for i in s:
            if i in dic:
                lis.append(dic[i])
            else:
                rem+=i
        lis.sort()
        for i in lis:
            rem+=dic1[i]
        return rem
