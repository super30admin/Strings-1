# Time Complexity : O(m+n) - n is len(s), m is len(order) as m is constant = 26 - O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no

class Solution(object):
    def customSortString(self, order, s):
        """
        :type order: str
        :type s: str
        :rtype: str
        """
        map = {}
        for i in range(0,len(s)):
            if s[i] in map:
                map[s[i]] += 1
            else:
                map[s[i]] = 1

        result = []
        for i in range(0,len(order)):
            if order[i] in map:
                for j in range(0,map[order[i]]):
                    result.append(order[i])
                del map[order[i]]

        for key in map:
            for j in range(0,map[key]):
                result.append(key)


        return "".join(result)


