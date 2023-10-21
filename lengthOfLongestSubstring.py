# Time Complexity: O(n)
# Space Complexity: O(1)

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """

        dict={}
        start=0
        res=0
        for idx in range(len(s)):
            char=s[idx]
            if char in dict:
                start=max(start,dict[char]+1) 
            dict[char]=idx
            res=max(res,idx-start+1)
        return res
                
