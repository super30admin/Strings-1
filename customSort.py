# Approach : Use hashmap to get count of all the letters from string s, then iterate over order string and for 
# each character in the order string, check if it is in count map, and add it that many times to result
# this ensures correct order. Lastly take all remaining characters from the map and append to result
# join result as string and return
# TC : O(n) as we are going over source string s and order string each 1 time and go over hashmap atmost 26 times
# SC : O(n) as we are using hashMap of size O(26) + Result list as aux data structure of length n.
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        count = {}
        res = []
        for char in s:
            count[char] = count.get(char,0) + 1
        
        for char in order:
            if char in count:
                while count[char] > 0:
                    res.append(char)
                    count[char] = count.get(char,0) - 1
        
        for k,v in count.items():
            if v > 0:
                while count[k] > 0:
                    res.append(k)
                    count[k] = count.get(k,0) - 1
        
        return ''.join(res)