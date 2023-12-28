# TC: O(M X N)
# SC: O(1)

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        dict1={}
        lis1=list(s)
        for i in lis1:
            if i not in dict1:
                dict1[i]=1
            else:
                dict1[i]+=1
        res=[]
        for i in range(0,len(order)):
            if order[i] in dict1:
                while dict1[order[i]]>0:
                    res.append(order[i])
                    dict1[order[i]]-=1

        for i in dict1:
            while dict1[i]>0:
                res.append(i)
                dict1[i]-=1

        return "".join(res)
        