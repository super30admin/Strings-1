# Time Complexity : O(m+n) m = len of order, n = len of source
# Space Complexity : O(n) max 26
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

from collections import defaultdict
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        chmap = defaultdict(int)
        res = ""
        for i in s:
            chmap[i] += 1
        
        for i in order:
            res += (i * chmap[i])
            chmap.pop(i,None)
        for i in chmap:
            res += (i * chmap[i])
        return res
        




        """
        :type root: TreeNode
        :rtype: bool
        """
        