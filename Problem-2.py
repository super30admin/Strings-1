#Time Complexity :O(n)
#Space Complexity :O(1) 
#Did this code successfully run on Leetcode :yes
#Any problem you faced while coding this : No
class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        if(len(s)==0 or s==None):
            return 0
        
        slow,maxi=0,0
        hmap={}
        
        for i in range(len(s)):
            if(s[i] in hmap):
                slow=max(hmap[s[i]],slow)
            maxi=max(maxi,i-slow+1)
            hmap[s[i]]=i+1
        
        return maxi
        