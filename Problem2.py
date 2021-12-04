#3. Longest Substring Without Repeating Characters
#time - O(n)
#space - o(n)
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        slow = 0
        fast = 0
        hashmap = {}
        max_len = 0
        
        while(fast < len(s)):
            
            if s[fast] in hashmap:
                
                slow = max(slow, hashmap[s[fast]])
            
            hashmap[s[fast]] = fast + 1
            max_len = max(max_len, fast - slow + 1)
            fast = fast + 1
            
        return max_len