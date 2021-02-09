class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        '''
        Time Complexity: O(n)
        Space Complexity: O(n)
        '''
        if(len(s)==0):
            return 0
        if(len(s)==1):
            return 1
        i = 0
        j = 0
        max1=0
        x = {}
        while(j<len(s)):
            if(s[j] not in x.keys()):
                x[s[j]] = j
                j+=1
            else:
                if(x[s[j]]>=i):
                    max1 = max(max1, j-i)
                    i = x[s[j]] + 1
                    x[s[j]] = j
                    j += 1
                else:
                    x[s[j]] = j
                    j += 1
                
                   
        return max(max1, j-i)
