'''
TC: O(n) //length of the string
SC:O(m) //number of distinct char in string
'''

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        hashMap = collections.defaultdict(int)
        maxLength = 0
        i = 0    
        
        for j in range(len(s)):
            hashMap[s[j]] += 1
            
            while j-i+1 > len(hashMap):
                hashMap[s[i]] -= 1
                if hashMap[s[i]] == 0:
                    hashMap.pop(s[i])
                i += 1
            
            if j-i+1 == len(hashMap):
                maxLength = max(maxLength, j-i+1)
        
        return maxLength