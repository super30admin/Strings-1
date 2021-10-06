class Solution:
    def customSortString(self, order: str, s: str) -> str:
        D = {}
        for i in range(len(s)):
            c = s[i]
            D[c] = D.get(c, 0) + 1

        L = []
        for i in range(len(order)):
            c = order[i]
            if c in D.keys():
                count = D.get(c)
                while count > 0:
                    L.append(c)
                    count -= 1
                D.pop(c)
        # to put remaining elements in the list
        for key in D.keys():
            count = D[key]
            while count > 0:
                L.append(key)
                count -= 1
        return "".join(L)

# TC = O(N+M)
# Space complexity : for Dictionary D O(1) and for List L O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : Syntax error
