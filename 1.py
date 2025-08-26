'''
Strings-1

Problem1

Custom Sort String (https://leetcode.com/problems/custom-sort-string/)
'''

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hashMap = dict()
        result = []
        for i in range(len(s)):
            c = s[i]
            if c not in hashMap:
                hashMap[c] = 1
            else:
                hashMap[c] = hashMap[c] + 1

        for i in range(len(order)):
            c = order[i]
            if c in hashMap:
                times = hashMap[c] 
                for j in range(times):
                    result.append(c)
                del hashMap[c]

        for key, values in hashMap.items():
            for i in range(values):
                result.append(key)

        return "".join(result)                                