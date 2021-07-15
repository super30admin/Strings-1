class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hmap={}
        if  not s or len(s)==0:
            return 0
        slow=0
        n=0
        res=[];
        for i in range(0,len(s)):
            
            if s[i] in hmap.keys():
                slow=max(slow,hmap.get(s[i]))
            n=max(n,i-slow+1)
            res.append(s[slow:n])
            hmap[s[i]]=i+1
        print(res)
        return n
            