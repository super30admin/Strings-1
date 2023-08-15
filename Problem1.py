class Solution:
    # Time Complexity: O(n)
    # Space Complexity: O(1)
    def customSortString(self, order: str, s: str) -> str:
        smap = {}
        for i in range(0, len(s)):
            if s[i] in smap:
                smap[s[i]] += 1
            else:
                smap[s[i]] = 1
        result = ""
        for i in range(0, len(order)):
            if order[i] in smap:
                count = smap[order[i]]
                for j in range(0, count):
                    result += order[i]
                del smap[order[i]]
        for key, value in smap.items():
            result += key * value
        return result
