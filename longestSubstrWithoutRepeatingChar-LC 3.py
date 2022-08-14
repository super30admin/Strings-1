# Using pointers and hashmap
# Time Complexity = O(n)
# Space Complexity = O(1)

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0:
            return 0
        
        # Initialising slow pointer, max val and hashmap
        slow = 0           # Slow pointer
        maxVal = 0
        hashMap = {}
        
        # i works as the fast pointer
        for i in range(slow, len(s)):
            char = s[i] 
            # If the char exists in map, found a duplicate. Move the slow pointer to the max index val b/w the current slow pointer and the old index of the duplicate char
            if char in hashMap:
                slow = max(slow, hashMap[char])
            
            # If the char doesn't exist in hashmap, add it
            hashMap[char] = i + 1
            maxVal = max(maxVal, i - slow + 1)          # fast - slow + 1 gives the len of substring
                
        return maxVal