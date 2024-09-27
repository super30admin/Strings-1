"""
Time complexity: O(M + N) Where M is the length of S and N is the length of T
Space complexity: O(N) we use auxillary hashmap of size N where N is the length of T
Compiled on leetcode?: Yes
Difficulties faced?: No
"""
from collections import Counter
class Solution:
    def customSortString(self, S: str, T: str) -> str:
        TCharacterFrequency = Counter(T)
        resultString = ""
        for character in S:
            if character in TCharacterFrequency:
                count = TCharacterFrequency[character]
                while count > 0:
                    resultString += character
                    count -= 1
                TCharacterFrequency[character] = count    
        
        for key, value in TCharacterFrequency.items():
            if value > 0:
                while TCharacterFrequency[key] > 0:
                    resultString += key
                    TCharacterFrequency[key] -= 1
        return resultString  