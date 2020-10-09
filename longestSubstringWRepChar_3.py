# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes 
# // Any problem you faced while coding this : No

# // Your code here along with comments explaining your approach: 
# Keep storing substrings in a set. If present in set, then increment start and remove the element from the set


class Solution:
    
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        start, end, maxm = 0,0,0
        
        output = set()
        
        while end<len(s):
            if s[end] not in output:
                output.add(s[end])
                end += 1
                maxm = max(maxm, len(output))
            else:
                output.remove(s[start])
                start += 1
                
        return maxm
        

