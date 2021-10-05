class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hmap={}
        # result=[]
        result=" "
        for i in range(len(s)):
            if s[i] not in hmap.keys():
                hmap[s[i]]=1
            else:
                hmap[s[i]]+=1
        for i in range(len(order)):
            if order[i] in hmap.keys():
                n=hmap[order[i]]
                # result.append(order[i]*n)
                result=result+(order[i]*n)
                del hmap[order[i]]
        for i in hmap.keys():
            n=hmap[i]
            # result.append(i*n)
            result=result+(i*n)
        return result.strip()
        
                
            
            
        