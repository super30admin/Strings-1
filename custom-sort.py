#time-complexity: O(m + n) where m is the length of the string order and n is the length of the string s
#space: O(n)

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        d={}
        #create a frequency map
        for i in s: # O(n) complexity
            if i not in d:
                d[i] = 0
            d[i] += 1
        out=''
        for i in order:
            count=d.get(i,0)
            out+= i*count
            d.pop(i,None)
        for key, val in d.items():
            out+=key*val
        return out
        