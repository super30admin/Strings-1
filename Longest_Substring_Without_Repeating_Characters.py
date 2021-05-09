class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        if not s:
            return 0
        
        hashmap = {}
        max_len = 0
        start = 0
        for i in range(len(s)):
            if s[i] in hashmap:
                start = max(start , hashmap[s[i]])
                #start = i
            hashmap[s[i]]=i+1              
            max_len = max(max_len, i - start + 1 )
        return max_len
            
            
        
