# Time: O(M+N)
# Space: O(1) for 26 letter hashmap
# Leetcode: Yes
# Issues: No

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hmap = {}

        for i in s:                 # create Frequency map for main String
            if i in hmap:
                hmap[i] += 1
            else:
                hmap[i] = 1
        
        res = ""                    
        for i in order:             # compare with order if its present in hmap
            if i in hmap:
                res += (hmap[i]*i)
                hmap.pop(i)         # remove once added to result
            
        for i in hmap:              # add remaining 
            res+=hmap[i]*i

        return res