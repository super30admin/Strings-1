'''
    Time Complexity: O(2n)
    Space Complexity: O(1)
'''
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hashMap = {}
        result = ""

        for char in s:
            if char not in hashMap:
                hashMap[char] = 1
            else:
                hashMap[char] += 1

        for char in order:
            if char in hashMap:
                result += char*hashMap[char]
                hashMap[char] = 0

        for char in hashMap.keys():
            result += char*hashMap[char]

        return result