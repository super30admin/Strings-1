# Time Complexity : O(S length + T length)
# Space Complexity : O(T length)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : 
# Your code here along with comments explaining your approach
class Solution:
    def customSortString(self, S: str, T: str) -> str:
        count = collections.Counter(T)
        ans = []
        
        for c in S:
            ans.append(c * count[c])
            count[c] = 0
        
        for c in count:
            ans.append(c * count[c])
            
        return "".join(ans)
