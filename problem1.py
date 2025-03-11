'''
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Three line explanation of solution in plain english : same implementation as in class

// Your code here along with comments explaining your approach
'''
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        cfreq = {}
        for c in s:
            if c not in cfreq:
                cfreq[c] = 1
            else:
                cfreq[c] += 1
        res = ''
        for i in order:
            if i in cfreq:
                res += i * cfreq[i]
                del cfreq[i]
        for ch, v in cfreq.items():
            res += ch * v

        return res