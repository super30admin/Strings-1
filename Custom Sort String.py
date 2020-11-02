# Strings
# TC: O(N)
# SC: O(N)
# No, it failed on Leetcode.
# Don't know how to do it.

class Solution:
    def customSortString(self, S: str, T: str) -> str:
        
        hmap_s = set()
        for i in S:
            hmap_s.add(i)
        
        hmap_t = set()
        for i in T:
            hmap_t.add(i)

        ans1 = ""
        ans2 = ""
        for i in T:
            if i not in hmap_s:
                ans1 += i
        for i in S:
            if i in hmap_t:
                ans2 += i
        return ans1+ans2