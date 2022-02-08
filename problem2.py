#Time Complexity O(N)
#Space Complexity O(1)
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        max_val = 0
        data=dict()
        
        count = 0
        for x in range(len(s)):
            if s[x] in data:
                count = max(data[s[x]],count)
            
            max_val = max(max_val,x -count +1 )
            data[s[x]] = x+1
        return max_val
                
                
        
