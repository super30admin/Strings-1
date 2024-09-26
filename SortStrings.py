#Time Complexity :O(T) where T is the length bugger string + O(S) where S is the length of smaller string
#Space Complexity : O(1)
class Solution:
    def customSortString(self, S: str, T: str) -> str:
        d ={}
        cnt = 0
        self.result = []
        for i in range(len(T)):
            c = T[i]
            
            if c in d:
                d[c]+=1
            else:
                d[c] = 1
        
        for i in range(len(S)):
            c = S[i]
            if c in d:
                cnt = d.get(c)
                while(cnt > 0):
                    self.result.append(c)
                    cnt-=1
                del d[c]
        
        for c in d:
            cnt = d[c]
            while cnt > 0:
                self.result.append(c)
                cnt-=1
        str1 = ''.join(self.result)
        return str1