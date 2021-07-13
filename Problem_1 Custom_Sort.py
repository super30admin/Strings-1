# // Time Complexity : O(m+n)
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No
#
#
# // Your code here along with comments explaining your approach

class Solution:
    def customSortString(self, S, T):
        if T == None:
            return ""
        hashmap = {}
        res = []
        for ch in T:
            if ch not in hashmap:
                hashmap[ch] = 0
            hashmap[ch] += 1

        for c in S:
            if c in hashmap:
                val = hashmap[c]
                while val:
                    res += c
                    val -= 1
                del hashmap[c]
        for k, v in hashmap.items():
            while v:
                res += k
                v -= 1

        return "".join(res)

