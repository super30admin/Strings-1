"""
I used a hashmap (Counter) to store character frequencies from string `s`. Built the result by appending characters in the order specified by `order`. Then added the remaining characters from `s` that were not in `order`. 
Time Complexity: O(n)
Space Complexity: O(n)
"""
from collections import Counter
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hashMap = Counter(s)
        result = []
        for char in order:
            if char in hashMap:
                result.append(char * hashMap[char])
                del hashMap[char]
        for key, value in hashMap.items():
            result.append(key * value)
        return ''.join(result)     