class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        #Approach: HashMap
        #Time Complexity: O(n)
        #Space Complexity: O(1)     // the charset is constant space
        
        lastSeen = {}
        maxLen = 0
        
        currLen = 0
        for i in range(len(s)):
            char = s[i]
            length = i - lastSeen.get(char, -1)
            currLen = min(currLen + 1, length)
            maxLen = max(maxLen, currLen)
            lastSeen[char] = i
              
        return maxLen