class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        result = 0
        for i in range(len(s)):
            temp = ""
            for j in range(i, len(s)):
                if s[j] not in temp:
                    temp += s[j]
                else:
                    break
            result = max(result, len(temp))
        
        return result
                
            
#Time complexity is O(N^2)
#Space complexity is O(N)