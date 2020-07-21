class Solution:
    
    """
        Name : Shahreen Shahjahan Psyche
        Time : O(N) [Where N is the size of string]
        Space: O(1) [Cause the hashmap will be max of 26]
    
    """
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        if not s:
            return 0
        
        low = 0
        high = 0
        ct = 0
        records = {}

        while high < len(s):
            if s[high] in records.keys():
                low = max(low, records[s[high]])
            records[s[high]] = high+1
            ct = max(high - low + 1, ct)
            high += 1
            
        return ct
            
            
        
        
