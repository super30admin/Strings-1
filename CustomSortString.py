# Time Complexity : O(n)
# Space Complexity : O(n)

class Solution:
    def customSortString(self, order: str, str: str) -> str:
        if len(str) < 2:
            return str

        a = {}

        # get the frequency of characters in the string
        for i in str:
            if i not in a:
                a[i] = 0
            a[i] += 1
        out = ""

        # add the order characters
        for i in order:
            if i in a:
                for j in range(a[i]):
                    out += i
                del a[i]

        # append remaining characters to the result string
        for i in a:
            for j in range(a[i]):
                out += i
        return out