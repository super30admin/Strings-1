class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        #Time: O(N) 
        #Space: O(N)
        i = 0
        j = 0
        
        # If length of string is less than or equal to 1
        if len(s)<=1:
            return len(s)
        H = {}
        sol = 0
        
        while j<len(s):
            
            # if current character already in Dictionary, update window start to the latest occurrence + 1 
            if s[j] in H:
                i=max(i,H[s[j]])
            sol = max(sol,j-i+1)
            
            # Add current index + 1 for current element in dictionaryreference to move start to if occurred again
            H[s[j]]=j+1
            j+=1
        return sol