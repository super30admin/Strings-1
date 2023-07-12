# Time Complexity :O(n)
# Space Complexity :O(1)
# Leet Code: Yes

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hashmap = {}
        res = ''

        for char in s:
            if char not in hashmap:
                hashmap[char] = 1
            else:
                hashmap[char] += 1

        for char in order:
            if char in hashmap:
                while hashmap[char] != 0:
                    res += char
                    hashmap[char] -= 1
                hashmap.pop(char)
        
        for char in hashmap:
            while hashmap[char] != 0:
                res += char
                hashmap[char] -= 1

        return res
