class Solution:
    def customSortString(self, S: str, T: str) -> str:
        count = [0]*26
        
        for l in T :
            count[ord(l) -ord('a')] += 1
            
        
        result = ""
        for c in S :
            result += c*count[ord(c) -ord('a')]
            count[ord(c) -ord('a')] = 0
        
        
        for i in range(26) :
            if count[i] > 0 :
                result += chr(i+ord('a'))*count[i]
        
        return result
        
        
