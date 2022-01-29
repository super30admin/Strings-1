# time complexity: O(n)
# space complexity: O(1)

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if s==None or len(s)==0: return 0
        hashmap={}
        slow=0
        maxi=0
        
        for i in range(len(s)):
            char=s[i]
            if char in hashmap:
                slow=max(slow, hashmap[char])
            
            maxi=max(maxi, i-slow+1)
            hashmap[char]=i+1
            
        return maxi