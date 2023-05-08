# TC : O(N + M)
# SC : O(N)

import collections

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        string = ""
        temp = collections.Counter(s)
        for i in order:
            if i in temp and temp[i] != 0:
                while temp[i] != 0:
                    string += i
                    temp[i] -= 1
        for key in temp:
            if temp[key] != 0:
                string += "".join(key * temp[key])
        return string