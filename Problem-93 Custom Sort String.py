# 791. Custom Sort String
# https://leetcode.com/problems/custom-sort-string/

# Logic: Iterate over s and make a count hashmap. Iteratrate over orders and add to the 
# result number of times the letter exists in the hashmap and also remove the entry from 
# hashmap. Iterate over the remaining keys in the hashmap and add to result.

# Time Complexiety: O(n)
# Space Complexiety: O(1) [worst case it will be O(26) if all the letters are to be put in the hashmap]

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hashmap = dict()
        
        for i in s:
            if i in hashmap:
                hashmap[i] += 1
            else:
                hashmap[i] = 1
        
        res = list()
        
        for i in order:
            if i in hashmap:
                for _ in range(hashmap[i]):
                    res.append(i)
                hashmap.pop(i)
        
        for i in hashmap:
            for j in range(hashmap[i]):
                res.append(i)
        
        return "".join(res)