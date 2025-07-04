
"""
Time- O(n)
Space - O(1)
"""
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