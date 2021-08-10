class Solution:
    def customSortString(self, order: str, s: str) -> str:
        if len(s)==0:
            return ""
        hashmap=dict()
        for i in range(len(s)):
            if s[i] not in hashmap:
                hashmap[s[i]]=0
            hashmap[s[i]]+=1
        result=""
        for v in order:
            if v in hashmap:
                result+=v*hashmap[v]
                del hashmap[v]
        for key,val in hashmap.items():
            result+=key*val
        return result      
        #Time O(m)+O(n)
        #space O(1) as only lowercase letters are considered=26
                
            
