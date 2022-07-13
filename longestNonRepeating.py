class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        """
        TC: O(n) where n is len of string
        SC: O(1) - this can be O(1) as hashmap will only have 26 chars at max
      
        """
        if len(s) == 0:
            return 0
        if len(s) == 1:
            return 1
        
        hmap = dict()
        
        
        res = 0
        
        low, high = 0, 0
        while high < len(s):
            if s[high] in hmap:
                low = max(low, hmap[s[high]]+1)
            hmap[s[high]] = high
            res = max(res, high - low + 1)
            high += 1
        return res
            
            