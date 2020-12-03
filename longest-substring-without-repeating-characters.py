class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        max_len=0
        ws =0
        freq={}
        for we in range(len(s)):
            ch = s[we]
            if ch in freq:
                ws = max(ws,freq[ch]+1)
            freq[ch] = we               
            
            max_len = max(max_len,we-ws+1)
        
        return max_len
                
        
