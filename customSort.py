"""
TC=O(M+N)
SC=O(1) -->Hashmap contains only 26 alphabets

"""


class Solution:
    def customSortString(self, S: str, T: str) -> str:
        d={}
        for i in range(0,len(T)):
            ch=T[i]
            if ch in d:
                d[ch]+=1
            else:
                d[ch]=1
        res=""
        for i in range(0,len(S)):
            ch=S[i]
            if ch in d:
                cnt=d[ch]
                while(cnt>0):
                    res+=ch
                    cnt-=1
                del d[ch]
        for key in d.keys():
            cnt=d[key]
            while(cnt>0):
                    res+=key
                    cnt-=1
             
            
        return res
                
        