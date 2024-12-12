# Time: O(m) 1 pass every element in s
# Space:O(1) hashset contains 26 chars 
# Leetcode: Yes
# Issues: In hashset solution the slow pointer only compares slow vs hmap[c]+1, The +1 is a packaged deal.

#hashset method
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n = len(s)
        hmap = {}                                       # {'a': 0, 'y' : 4}
        maxsize = 0
        slow = 0

        for i in range(n):
            c = s[i]
            if c in hmap:                               # if the occurance of new element is before or after slow. 
                slow = max(slow , hmap[c]+1)            # Slow marks the sart of our sliding window
            hmap[c] = i
            maxsize = max(maxsize, i-slow+1)            # compare current maxsize or difference between 2 pointers
        return maxsize
        
# sliding window T: O(n) string // S:O(1)hashset 26 chars
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        n = len(s)
        hset = set()            # {a,c,b,s,x,q}
        maxsize = 0

        slow = 0                # dont init till we get repeating

        for i in range(len(s)):
            c = s[i]
            if c in hset:                   # not used untill dupe found
                while s[slow] != c:
                    hset.remove(s[slow])
                    slow+=1
                slow +=1
            hset.add(c)
            maxsize = max(maxsize, i-slow+1)        
        return maxsize
        