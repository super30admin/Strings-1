#time : 0(n)
#sapce: 0(max length substring)
class Solution(object):
    def lengthOfLongestSubstring(self, s):
        n = len(s)
        
        if n == 0:
            return 0
        
        myset = set()
        
        i = 0
        j =  0 
        res = 0
        
        for j in range(n):
            while s[j] in myset :
                myset.remove(s[i])
                i = i + 1
            
            myset.add(s[j])
            res = max(res,j-i+1)
        
        return res
            
        
        
        """
        :type s: str
        :rtype: int
        """
        