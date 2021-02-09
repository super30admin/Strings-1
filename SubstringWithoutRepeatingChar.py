class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        '''
        Time Complexity: O(2n)
        Space Complexity: O(n)
        '''
        if(len(s)==0):
            return 0
        if(len(s)==1):
            return 1
        i = 0
        j = 0
        max1=0
        while(True):
            x = {}
            while(j<len(s) and s[j] not in x.keys()):
                x[s[j]] = j
                j+=1
                
            if(max1< len(x.keys())):
                max1 = len(x.keys())
            if(j==len(s)):
                break
            i = x[s[j]]+1
            j = i
                   
        return max1
