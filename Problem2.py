"""
3. Longest Substring Without Repeating Characters
Time Complexity - O(n)
Space Complexity - O(n)
Here we are using sliding windoe teschnique with start and end pointers
Going through the entire while loop and then keep storing the character and its index in hashmap,
if new character is in hashmap then change the start value and again continue replacing index to character and finding max string length without repeating characters"""
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0 or s == None:
            return 0
        hashmap = {}
        max_val = float("-inf")
        start = 0
        end = 0
        
        while(end < len(s)):
            if s[end] in hashmap:
                start = max(start,hashmap[s[end]])
            hashmap[s[end]] = end+1
            max_val = max(max_val,end - start + 1) 
            end += 1
        return max_val