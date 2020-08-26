"""
Problem:
https://leetcode.com/problems/longest-substring-without-repeating-characters/

Approach: 
1. take 2 pointers slow and fast each pointing to the start of the string
2. keep a map of each char and its index 
3. traveres the string with fast pointer and check if the char pointed by fast is in the map, if its in the map, move the slow pointer to one index ahead of the value got from the map
4. at each point find the length of the string using length= fast-slow+1



"""

# Time Complexity : O(n) , where n is the length of the string
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : yes	
# Any problem you faced while coding this : No


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s or len(s)==0:
            return 0
        start,end =0,0
        slow,fast = 0,0
        map1={}
        maxLen = 0
        for fast in range(len(s)):
            if s[fast] in map1:
                slow = max(map1[s[fast]]+1,slow)
            
            if fast-slow+1>maxLen:
                maxLen = fast-slow+1
                start,end=slow,fast
            
            map1[s[fast]]=fast
        #print(start,end) start and end will be the index of the longest substring
        return maxLen
            
                
        
        