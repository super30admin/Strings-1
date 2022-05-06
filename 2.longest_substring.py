// Time Complexity : O(n)
// Space Complexity : O(1) i.e. dictionary o(26)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        start=0
        end=0
        count=0
        
        r=set()
        while(end<len(s)):

            if  s[end] in r:
                r.remove(s[start])
                start=start+1
                
                
            else:
                r.add(s[end])
                count=max(count,end+1-start)
                end=end+1

        return count
        










// Time Complexity : O(n*n)
// Space Complexity : O(1) i.e. dictionary o(26)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        count =0 
        
        for i in range(0,len(s)):
            r=set()
            j=i
            while  j<len(s):
                if not (s[j] in r):
                    r.add(s[j])
                    j=j+1

                else:
                  break

            count=max(count,j-i)
        return count
        