class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        currLetters = set()
        left, right = 0, 0
        output = 0
        while left<len(s) and right<len(s):
            if s[right] not in currLetters:
                currLetters.add(s[right])
                right+=1
            else:
                output = max(output, right-left)
                currLetters.remove(s[left])
                left+=1
        output = max(output, (right-left))
        return output
                
            
