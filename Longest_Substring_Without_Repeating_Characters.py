class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        l={}
        slow=0
        maximum=-math.inf
        
        if s=="":
            return 0
        
        for i in range(len(s)):
            if s[i] in l:
                slow=max(slow,l[s[i]])
            l[s[i]]=i+1
            maximum=max(maximum,i-slow+1)
            
        return maximum