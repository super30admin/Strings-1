# Runs on Leetcode
    # m - length of s
    # n - length of t
        # Runtime - O(m + n)
        # Space - O(n)


class Solution:
    def customSortString(self, s: str, t: str) -> str:
        if not s:
            return s
        
        d= {}
        for i in t:
            if i not in d:
                d[i] = 1
            else:
                d[i] += 1

        result = ""
        
        for i in s:
            if i in d:
                for _ in range(d[i]):
                    result += i
                    d[i] -= 1
                    if d[i] == 0:
                        del d[i]

        if not len(d):
            return result
        
        for i in d:
            for j in range(d[i]):
                result += i
        return result
