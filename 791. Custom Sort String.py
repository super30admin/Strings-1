# time complexity: O(m+n)
# space complexity: O(1)

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        if len(s)==0 or s==None: return None
        
        hashmap={}
        result=""
        
        for i in s:
            hashmap[i]=hashmap.get(i, 0)+1
        
        for i in range(len(order)):
            let=order[i]
            if let in hashmap:
                tail=let*hashmap[let]
                result+=tail
                del hashmap[let]
            
        for char in hashmap.keys():
            tail=char*hashmap[char]
            result+=tail
            
        return result
                