class Solution:
    def customSortString(self, order: str, s: str) -> str:
        l={}
        for i in s:
            if i not in l:
                l[i]=0
            l[i]+=1
            
        s=''
        for i in range(len(order)):
            if order[i] in l:
                s+=order[i]*l[order[i]]
                del l[order[i]]
                
        for key,val in l.items():
            s+=val*key
            
        return s
            
        
                