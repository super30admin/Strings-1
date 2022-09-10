#  791. Custom Sort String
'''
Leetcode all test cases passed: Yes
class Solution:
    customSortString(self, order: str, s: str) -> str:
      n is length of s
      Time Complexity: O(n)
      Space Complexity: O(1)
'''
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hmap = {}
        for ch in s:
            if ch not in hmap:
                hmap[ch] = 0
            hmap[ch] += 1
        res =""
        for ch in order:
            if ch in hmap:
                res += ch * hmap[ch]
                del hmap[ch]
        keys = list(hmap.keys())
        for key in keys:
            res += key * hmap[key]
            del hmap[key]
        return res
