## Problem1 
#Custom Sort String (https://leetcode.com/problems/custom-sort-string/)

# Approach:
# Traverse through string s and add char freq to hmap. Traverse through string order, if char in hmap, append char to result string freq number of times. del char entry from hmap
# Traverse hmap for rest of the chars, add char freq number of times to result string. Return result


# Time Complexity: O(m+n)
# Space Complexity: O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No



class Solution:
    def customSortString(self, order: str, s: str) -> str:
        res = ''
        hmap = {}
        for c in s:
            if c in hmap:
                hmap[c] += 1
            else:
                hmap[c] = 1
        
        for o in order:
            if o in hmap:
                while hmap[o]!= 0:
                    res = res + o
                    hmap[o] -= 1
                del hmap[o]
        
        for i in hmap:
            freq = hmap[i]
            for k in range(freq):
                res = res + i
            
        
        return res