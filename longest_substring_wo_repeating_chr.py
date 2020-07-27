# Time Complexity : Add - O(n)
# Space Complexity :O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No
'''
1. Sliding window using slow and fast pointers
2. Keep sliding your fast while taking max_ along the way, and storing the chr with index
3. If a dublicate is found, move your slow to previous occurence of dublicate chr by accesing hahsmap, and
4. reset all the charachters from previou slow to new slow
'''

import sys
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        if not s or len(s) < 1:
            return 0
        
        max_ = -sys.maxsize
        hashmap = {}
        
        slow = 0
        fast = 0
        
        while fast < len(s):
            
            if s[fast] not in hashmap:
                #if letter does not exists already consider it as the part of length
                max_ = max(max_, fast-slow+1)
            else:
                #if letter exists already do not consider it as the part of length
                max_ = max(max_, fast-slow) 
                
                '''
                once you have found the dublicate ltter, move your slow to new position
                while deleting the hashmap along the way
                '''
                new_slow = hashmap[s[fast]]+1                
                while slow < new_slow:
                    del hashmap[s[slow]]
                    slow += 1
                            
            hashmap[s[fast]] = fast
            fast += 1
            
        return max_
                
                
        