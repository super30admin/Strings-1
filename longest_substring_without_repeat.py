# sc : O(N)
# tc : O(N) 
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        m = dict()
        if len(s) ==0 or len(s) == 1:
            return len(s)
        slow = 0
        
        maxi = -10000000000
        
        for i in range(len(s)):
            ch = s[i]
            if ch in m:
                slow = max(slow, m[ch])
                m[ch] = i + 1
            else:
                m[ch] = i + 1
            
            maxi = max(maxi,  i - slow + 1)
        
        return maxi
                
