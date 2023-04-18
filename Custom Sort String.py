# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hmap = collections.defaultdict(int)
        res = ''
        for ch in s:
            hmap[ch] += 1

            # print(hmap)

        for i in order:
            res += i * hmap[i]
            hmap[i] = 0

        for key, val in hmap.items():
            res += key * val

        return res




