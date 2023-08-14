# Time Complexity: O(|order| + |s|)
# Space Complexity: O(26)
# Did this code successfully run on Leetcode: Yes
# Any problem you faced while coding this: No

class Solution(object):
    def customSortString(self, order, s):
        """
        :type order: str
        :type s: str
        :rtype: str
        """
        dic = {}
        for i in s:
            if i not in dic:
                dic[i] = 1
            else:
                dic[i] += 1
        res = ''
        for x in order:
            if x in s:
                res += (x * dic[x])
        for y in s:
            if y not in res:
                res += (y * dic[y])
        return res