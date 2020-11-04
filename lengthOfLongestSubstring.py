class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        hmap ={}
        output = 0
        start = 0
        
        for curr in range(0,len(s)):
            ch = s[curr]
            
            if ch in hmap:
                start = max(hmap[ch]+1,start)
                
            output = max(curr-start+1,output)
            hmap[ch] = curr
            
        return output

# Time Complexity: O(n)
# Space Complexity: O(n)