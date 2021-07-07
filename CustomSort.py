"""// Time Complexity : o(n)
// Space Complexity : o(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
"""
class Solution(object):
    def customSortString(self, S, T):
        """
        :type S: str
        :type T: str
        :rtype: str
        """
        count = {}
        
        for char in T:
            count[char] = count.get(char,0) + 1
            
        output = []
        
        for char in S:
            if char in count:
                output.append(char * count.get(char))
    
        for char in T:
            if not char in S:
                output.append(char)
                
        return ''.join(output)
        