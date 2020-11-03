# Time Complexity :- O(N + N) = O(N)
# Space Complexity :- O(N)
# Ran on LeetCode :- Yes

from collections import Counter

class Solution:
    def customSortString(self, S: str, T: str) -> str:
        
        
        hashMap = Counter(T)
        
        finalString = ""
        for char in S:
            # if char in hashMap (not needed for this)
            finalString += char*hashMap[char]
            del hashMap[char]

        for rem in hashMap.keys():
            finalString += rem*hashMap[rem]
        
        return finalString
