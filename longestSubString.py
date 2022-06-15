#Time complexity: O(n)
#space complexity: o(n)
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        st=set()
        res=0
        l=0
        for r in range(len(s)):
            while s[r] in st:
                st.remove(s[l])
                l+=1
            st.add(s[r])
            res=max(res,len(st))
        return res
    
    
    
    class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        slow=0
        dict1={}
        maxi=0
        for i in range(len(s)):
            if s[i] in dict1:
                slow=max(slow,dict1[s[i]]+1)
            dict1[s[i]]=i
            
            maxi=max(i-slow+1,maxi)
        return maxi
            
        
