# Using hashset
# Time Complexity - O(2n)
# Space Complexity - O(1)

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        slow = 0 
        hashset = set()
        maxlen = 0
        for i in range(len(s)):
            if s[i] in hashset: 
                while s[slow] != s[i]: 
                    hashset.remove(s[slow])
                    slow += 1 
                slow += 1

            else : 
                hashset.add(s[i]) 

            maxlen = max(maxlen,i-slow+1)
        return maxlen
# Using hashmap
# Time Complexity - O(n)
# Space Complexity - O(1)       

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        slow = 0 
        hashmap = {}
        maxlen = 0
        for i in range(len(s)):
            if s[i] in hashmap: 
                idx = hashmap[s[i]]
                slow = max(slow,idx + 1 )
                hashmap[s[i]] = i 
            else : 
                hashmap[s[i]] = i 

            maxlen = max(maxlen,i-slow+1)
        return maxlen
        