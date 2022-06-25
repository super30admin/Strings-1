class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hashmap={}
        output=''
        for i in range(len(s)):
            hashmap[s[i]]=hashmap.get(s[i],0)+1
            
        for char in order:
            if char in hashmap:
                while hashmap[char]!=0:
                    output+=char
                    hashmap[char]-=1
                    
        for key,value in hashmap.items():
            if value!=0:
                while value!=0:
                    output+=key
                    value-=1
            
        return output
                
                    
        