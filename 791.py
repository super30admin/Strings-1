
#time: o(n)
#space: o(n)
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        dict1={}
        for c in s:
            dict1[c]=dict1.get(c,0)+1
        res=[]
        for c in order:
            
            if dict1.get(c):
                res.append(c*dict1[c])
                del dict1[c]
        for c in dict1:
            res.append(c*dict1[c])
        return ''.join(res)  