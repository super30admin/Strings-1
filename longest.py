class Solution:
    #     #Tc - o(n^3)
    #     #SC - O(1) as in set constant time to store 26 characters
    #     ## Brute force Approach
    # def lengthOfLongestSubstring(self, s: str) -> int:
    #     if not s:
    #         return 0
    #     maxLen = float('-inf') 
    #     for i in range(len(s)):
    #         for j in range(i, len(s)):
    #             count = self.checkUniqueCharacters(s[i:j+1])
    #             if count != -1:  
    #                 maxLen = max(maxLen, count)
    #     return maxLen

    # def checkUniqueCharacters(self, s):
    #     myset = set()
    #     for ch in s:
    #         if ch in myset:
    #             return -1 
    #         myset.add(ch)
    #     return len(s) 


    ## optimized Approach
    #TC - O(n)
    # SC- O(1)
    def lengthOfLongestSubstring(self, s: str) -> int:   
        if not s:
            return 0
        freqMap = defaultdict(int)
        start = 0
        maxLen = 0     
        for i in range(len(s)):
            ch = s[i]
            if ch in freqMap:
                start = max(start,freqMap.get(ch))
            maxLen = max(maxLen, i-start+1)   
            freqMap[ch]  = i+1
        return maxLen     


