'''
Time Complexity --> O(n)
Space Complexity --> O(n)
'''
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        dit = {}
        for i in s:
            try:
                dit[i]+=1
            except:
                dit[i]=1
        res = ''
        for ch in order:
            if ch in dit:
                res+=ch*dit[ch]
                dit[ch] = 0
        for k,v in dit.items():
            if v!=0:
                res+=k*v
        return(res)

