'''
Time Complexity - O(n)
Space Complexity - O(1)
'''


class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hmap = {}
        res = ""
        for char in s:
            if char not in hmap:
                hmap[char] = 1
            else:
                hmap[char] += 1

        for char in order:
            if char in hmap:
                freq = hmap[char]
                for i in range(freq):
                    res += char
                del hmap[char]

        for char in hmap:
            freq = hmap[char]
            for i in range(freq):
                res += char
        return res
