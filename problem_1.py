# Time Complexity - O(n+m)
# Space Complexity - O(1)


class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hashmap = {}
        out = ""
        for i in range(len(s)):
            if s[i] in hashmap: 
                hashmap[s[i]] += 1 

            else : 
                hashmap[s[i]] = 1 

        for i in range(len(order)):
            if order[i] in hashmap: 
                for j in range(hashmap[order[i]]):
                    out += order[i]
                del hashmap[order[i]]
        for key, val in hashmap.items(): 
            for j in range(val):
                out += key

        return out 
           
            

