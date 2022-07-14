"""
We will check for characters from the the order string and check if it is there in the Source string. 
We can store the frequencies of all the characters from the source string in a hashmap, then traverse on order string and check for the number of occurrences and append it to the
result string

TC = O(m+n) - Creating Hashmap + traversing on source string to build final result
SC = O(n) - Hashmap

"""

class Solution:
    def customSortString(self, order: str, source: str) -> str:
        result = ''
        hmap = {}
        for i in range(len(source)):
            hmap[source[i]] = hmap.get(source[i],0) + 1
            
        for c in order:
            if c in hmap:
                while hmap[c]!=0:
                    result+=c
                    hmap[c]-=1
                
        for k,v in hmap.items():
            if hmap[k]>0:
                while hmap[k]>0:
                    result+=k
                    hmap[k]-=1
                
        return result
            
                
        