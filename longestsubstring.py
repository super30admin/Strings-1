#Time complexity: O(n)
#Space compleexity: O(n) for hashmap
#Running on leetcode: Yes
#Problems faced: None

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        if s == None or len(s) == 0:
            return 0
        hm = {}
        maximum = float('-inf')
        start = 0
        for i in range(len(s)):
            if s[i] in hm and start<=hm[s[i]]:
                start = hm[s[i]]+1
            else:
                maximum = max(i-start+1,maximum)
            hm[s[i]] = i
        return maximum
            
        
                
                
        
            
                
                
                
        