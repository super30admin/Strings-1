#Time Complexity - O(N)
#Space Complexity - O(N)

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        dic_s = {}
        
        for i in s:
            if i not in dic_s:
                dic_s[i] = 1
            else:
                dic_s[i] +=1
        
        strr = ""        
        for i in order:
            if i in dic_s:
                count = dic_s[i]
                for j in range(count):
                    strr += i
                del dic_s[i]
        
        for i,j in dic_s.items():
            count = dic_s[i]
            for j in range(count):
                strr += i                
        
        return strr