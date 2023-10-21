# Time Complexity: O(n)
# Space Complexity: O(1)
from collections import Counter

class Solution(object):
    def customSortString(self, order, s):
        """
        :type order: str
        :type s: str
        :rtype: str
        """
        dict = Counter(s)
        #print(dict)
        res = ""
        for i in range(len(order)):
            if order[i] in dict:
                res += order[i]*dict[order[i]]
                #print(res)
                del dict[order[i]]

        for char in dict:
            res += char*dict[char]

        return res
