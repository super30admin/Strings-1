class Solution:
    def customSortString(self, S: str, T: str) -> str:
        
        freq ={}
        for i in range(len(T)):
            c = T[i]
            if c not in freq:
                freq[c]=1
            else:
                freq[c]+=1
        res = ""
        for i in range(len(S)):
            c = S[i]
            if c in freq:
                cnt = freq[c]
                while cnt>0:
                    res = res + c
                    cnt-=1
                del freq[c]
        for c in freq.keys():
            cnt = freq[c]
            while cnt>0:
                res = res+c
                cnt-=1
        
        return res
            
            
