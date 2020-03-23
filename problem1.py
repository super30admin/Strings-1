'''
Time Complexity: O(n+m) n is length of S and m is length of T
Space Complexity: O(m) - > m is the length of T
Did this code successfully run on Leetcode : Yes
Explanation: Count all the characters from T. For ever character in S multiple the  character in S by the number of times
the character occurs in T and do this in order. Once S is complete any remaining characters are in T and add them to the\
end.
'''
class Solution:
    def customSortString(self, S: str, T: str) -> str:
        hashMap = {}
        for i in T:
            if i not in hashMap.keys():
                hashMap[i] = 1
            else:
                hashMap[i] = hashMap[i] + 1
        res = []
        for c in S:
            if c in hashMap:
                res.append(c * hashMap[c])
                hashMap[c] = 0

        for c in hashMap:
            res.append(c * hashMap[c])

        return "".join(res)