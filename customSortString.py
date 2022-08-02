# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        mp = {}
        ordered = []
        rest = []

        for c in s:
            mp[c] = mp.get(c, 0) + 1

        for c in order:
            if c not in mp:
                continue
            elif c in mp:
                while mp[c] > 0: # Append all the same
                    ordered.append(c)
                    mp[c] -= 1

        for c in mp:
            while mp[c] > 0:
                rest.append(c)
                mp[c] -= 1

        res = ''.join(ordered + rest)

        return res
