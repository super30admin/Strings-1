# Approach: Brute force approach would be getting substrings and checking if there are any duplicate characters
# 2 nested for loops - O( N ^ 2) Time complexity

# Optimized Solution
# Using sliding window everytime we come across a new charac we record the index at which we need to skip this charac if we come across duplicates
# If character is already in hashmap, update the start Index pointer to max(startIdx , index which needs to be skipped)
# Time - O(N)
# Space - O(N) since we use a hashmap

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        if not s or len(s) == 0:
            return 0
        
        startIdx = 0
        maxLength = float("-inf")
        
        lastSeen = {}
        
        for idx, char in enumerate(s):
            if char in lastSeen:
        
                startIdx = max(startIdx, lastSeen[char]) # max since we could potentially traverse back including duplicate characs
            
            lastSeen[char] = idx + 1 # we do idx + 1 so that it represents the index which we need to consider after skipping duplicate
            maxLength = max(maxLength, idx - startIdx +1)
        
        return maxLength
                
            
            
        
            