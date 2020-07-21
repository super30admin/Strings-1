"""
// Time Complexity : O(n), length of T
// Space Complexity : O(1), max 26
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
"""

from collections import defaultdict
class Solution(object):
    def customSortString(self, S, T):
        """
        :type S: str
        :type T: str
        :rtype: str
        """
        dict = defaultdict(int)# for storing chars in T and their frequencies
        res = ""

        for i in T:
            dict[i] += 1
            
        for i in S: #for chars present in S in order, keep adding to result and then remove them from the dictionary 
            res = res + i*dict[i]
            dict.pop(i)
        
        for k,v in dict.items(): #add remaining chars to res in any order
            res = res + k*v
            
        return res