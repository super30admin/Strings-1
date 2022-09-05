#Time complexity: O(1)
#Space complexity: O(n)
#Worked in Leetcode: Yes
#Issues: No

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hashmap = {}
        for i in range(len(s)):
            c = s[i]
            hashmap[c] = hashmap.get(c, 0) + 1
            
        result = ""
        for i in range(len(order)):
            c = order[i]
            if c in hashmap:
                count = hashmap.get(c)
                for k in range(count):
                    result += c
                hashmap.pop(c)
                
                
        #keys that are not in the order string
        for c in hashmap:
            count = hashmap.get(c)
            for k in range(count):
                result += c
                
        return result
