# Time Complexity: O(m + n)
# Space Complexity: O(n)        # result string

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        d = dict()
        result = ""

        for i in s:
            if i not in d:
                d.update({i : 0})
            else:
                d.update({i : d.get(i) + 1})

        for i in order:
            if i in d:
                count = 0
                while count <= d.get(i):
                    result = result + i
                    count += 1
                del d[i]

        for i in d:
            count = 0
            while count <= d.get(i):
                result = result + i
                count += 1

        return result