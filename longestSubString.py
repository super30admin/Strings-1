class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s:
            return 0
        
        slow, fast, maxVal = 0, 0, 0
        dataStore = dict()
        
        while fast<len(s):
            if s[fast] in dataStore:
                slow = max(slow, dataStore[s[fast]])
            
            dataStore[s[fast]] = fast+1
            maxVal = max(maxVal, fast - slow +1)
            fast += 1
        
        return maxVal
    
#      Time complexity is O(n) 
        
        
