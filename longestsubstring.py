'''
Time Complexity: O(n)
Space Complexity: O(1)
'''
class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        if(len(s)==0): return 0
        l = r = 0
        hashmap = {}
        maxlen = float("-inf")
        while(r<=len(s)-1):
            if(s[r] in hashmap and hashmap[s[r]]>l):
                l = hashmap[s[r]]
            hashmap[s[r]] = r+1
            maxlen = max(maxlen, (r-l)+1)
            r += 1
        return maxlen
                    
                    
                
                
        