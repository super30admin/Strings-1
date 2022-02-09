# Time Complexity : O(m+n) where m is the length of the order. which can not be more than 26. then it can be O(n)
# Space Complexity:o(1)
#  Did this code successfully run on Leetcode : Yes

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        if s is None or len(s) == 0:
            return ""

        hashMap = {}
        result = ""
        for c in s:
            hashMap[c] = hashMap.get(c, 0) + 1

        for c in order:
            if c in hashMap:
                for i in range(0, hashMap[c]):
                    result += c

                hashMap.pop(c)

        for key in hashMap.keys():
            for i in range(0, hashMap[key]):
                result += key

        return result
