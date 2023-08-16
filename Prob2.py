# Time Complexity -O(n)
# Space Complexity - O(1)
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        d=Counter(s) #get frequency of s
        res=''
        for i in range(len(order)): #then iterate over order
            if order[i] in d: #if order[i] in d, then append it to the res
                res += order[i]*d[order[i]]
                del d[order[i]] #delete it once done with it
        
        for key in d.keys(): #now, left over in s apppend it in the end of res
            res+=key*d[key]
        return res
