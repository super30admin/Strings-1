# Time Complexity = O(3n) = O(n)
# Space Complexity = O(n) 
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

import collections
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        
        # create a frequency hashmap of s
        count = collections.Counter(s)
        ans = []

        # add the elemens in order from hashmap
        for c in order:
            ans.append(c * count[c])
            count[c] = 0

        # add remaining elements in the list
        for c in count:
            ans.append(c * count[c])
                
        return "".join(ans)