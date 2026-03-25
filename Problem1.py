# https://leetcode.com/problems/custom-sort-string/

# TC: O(m) => length of s
# SC: O(1)
# Any problem you faced while coding this : no

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hm = {}
        res = ""

        for i in s:
            if i not in hm:
                hm[i] = 1
            else:
                hm[i] += 1

        # Add chars based on order
        for ch in order:
            if ch in hm:
                res += ch * hm[ch]
                hm.pop(ch)

        # Add remaining chars
        for ch, freq in hm.items():
            res += ch * freq

        return res