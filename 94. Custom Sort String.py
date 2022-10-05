# Time Complexity: O(n)
# Space Complexity: O(1)

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hashmap = {}
        result = ""
        for i in s:
            if i in hashmap:
                hashmap[i] += 1
            else:
                hashmap[i] = 1
                
        for i in order:
            if i in hashmap:
                x = hashmap[i]
                while(x != 0):
                    result += i
                    x -= 1
                hashmap.pop(i)
        
        for key in hashmap.keys():
            x = hashmap[key]
            while(x != 0):
                result += key
                x -= 1
            
        return result