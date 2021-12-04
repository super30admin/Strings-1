#leetcode 791 Custom Sort String
#Time - O(n)
#Space - O(n)
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        
        hashmap = {}
        for char in s:
            if char not in hashmap:
                hashmap[char] = 1
            else:
                hashmap[char] += 1
        
        result = ""
        
        for char in order:
            
            if char in hashmap:
                result = result + hashmap[char] * char
                del hashmap[char]
        
        
        for char in hashmap:
            
            result = result + hashmap[char] * char
        
        return result