#Time complexity: O(n)
#Space complexity: O(n)
#Worked in Leetcode: Yes
#Issues: No

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        hashmap = {}
        slow = 0
        maxi = 0
        
        for i in range(len(s)):
            c = s[i]
            if(c in hashmap):
                slow = max(slow, hashmap.get(c))
                
            maxi = max(maxi, i - slow + 1)
            hashmap[c] = i + 1
            
        return maxi
                
