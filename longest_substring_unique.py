# Time Complexity :first methode=O(N)+O(N), second= O(N)
# Space Complexity :O(N)
# Did this code successfully run on Leetcode : Yes

# Any problem you faced while coding this :

# Your code here along with comments explaining your approach

# first
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        h={}
        slow=0
        m=0
        for i in range(len(s)):
            if(h.get(s[i],0)):
                while(s[slow]!=s[i]):
                    h[s[slow]]-=1
                    slow+=1
                slow+=1
            else:
                h[s[i]]=h.get(s[i],0)+1
            m=max(m, i-slow+1)
        return m

# second
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        h={}
        slow=0
        m=0
        n=len(s)
        for i in range(n):
            if(h.get(s[i],-1)!=-1):                
                slow=max(h[s[i]]+1, slow)
                h[s[i]]=i
            else:
                h[s[i]]=h.get(s[i],-1)+1+i
            m=max(m, i-slow+1)
        return m