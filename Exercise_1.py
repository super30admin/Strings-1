class Solution:
    def customSortString(self, order: str, str: str) -> str:
        hmap={}
        
        s=""
        for i in range(len(str)):
            if str[i] in hmap.keys():
                hmap[str[i]]=hmap[str[i]]=hmap[str[i]]+1
            else:
                hmap[str[i]]=1
        for i in range(len(order)):
            if order[i] in hmap.keys():
                for j in range(hmap[order[i]]):
                    s=s+order[i]
                hmap.pop(order[i])
        for i in hmap.keys():
            c=hmap[i]
            while c>0:
                s=s+i
                c=c-1
                
            
        return s