#Time complexity: O(m+n)
#Space complexity: O(n); for string creation

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hMap = dict()
        
        for char in s:
            if char in hMap:
                hMap[char] += 1
            else:
                hMap[char] = 1
        
        res = []
        for i in range(len(order)):
            if order[i] in hMap:
                freq = hMap[order[i]]
                for k in range(freq):
                    res.append(order[i])
                del hMap[order[i]]
        for key in hMap:
            freq = hMap[key]
            for k in range(freq):
                res.append(key)
        
        return ''.join(res)
            
            
            
                
        
