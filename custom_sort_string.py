# Time Complexity : O(m+n)
# Space Complexity : O(m);
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
#
#
from collections import Counter


class Solution:
    def customSortString(self, order: str, s: str) -> str:
        dictu = Counter(s)
        result = []
        for i in order:
            if i in dictu:
                while dictu[i] > 0:
                    result.append(i)
                    dictu[i] -= 1
        if dictu:
            for i in dictu:
                while dictu[i] > 0:
                    result.append(i)
                    dictu[i] -= 1
        return ''.join(result)


print(Solution().customSortString('cba', 'abcd'))
