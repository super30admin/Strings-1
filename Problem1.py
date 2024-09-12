# Time Complexity : O(n) when is length of string T
# Space Complexity :O(n) when is length of string T
# Did this code successfully run on Leetcode :Yes
# Any problem you faced while coding this : No

import collections
class Solution:
    def customSortString(self, S: str, T: str) -> str:

        # --Method 1------
        # Made list for storing occurances of T elements in S
        # indx = [-1]*len(T)
        # Looped and stored indexes of T elements in S
        # for c in range(len(T)):
        #     if T[c] in S:
        #         indx[c] = S.index(T[c])
        # Zipped indexes so that I can sort the elements of T according to sequence in S
        # preans = sorted(zip(indx,T))
        # s = ''
        # Made string from the list
        # for idx, char in preans:
        #     s += char
        # return s
        # This solution is O(nlogn) where n is length of T

        # --Method-2---------
        # Made Dictionary of T values to stor single or multiple occurances
        cntr = collections.Counter(T)
        ans = ''
        # Now Store All occurances of S in T into ans
        for i in S:
            if i in cntr and cntr[i] > 0:
                ans += i * cntr[i]
        # Now Store All occurances of T  not in S into ans
        for i in cntr:
            if i not in S:
                ans += i * cntr[i]
        return ans
