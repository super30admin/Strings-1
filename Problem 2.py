# Time Complexity: O(n)
# Space Complexity: O(1) # Becuase there can be a maximum of 26 entries in the dictionary
class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        dic = {}
        res = 0
        lst = 0
        for i in range(len(s)):
            if s[i] in dic:
                lst = max(lst, dic[s[i]]+1)
            res = max(res, i-lst+1)
            dic[s[i]] = i
        return res
                
                
        
