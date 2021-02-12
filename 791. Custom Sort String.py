# T = O(n)
# S = O(1)

# Approach:
# we will traverse through T and put all the chars in it inside a dictionary with the count. Then, we will
# start traversing through s and as we do, we will look into the dictionary and start appending the character
# according to its count into a resultant string.

class Solution:
    def customSortString(self, S: str, T: str) -> str:
        d = {}
        for char in T:
            if char in d:
                d[char] += 1
            else:
                d[char] = 1
        res = []
        for char in S:
            if char in d:
                res.append(char*d[char])
                d.pop(char)
        for char in d:
            res.append(char*d[char])
        return "".join(res)
        