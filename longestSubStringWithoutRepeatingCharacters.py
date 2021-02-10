# Time Complexity : O(N)
# Space Complexity : O(1) size of hashmap of letters so O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        """
        hm = {letter : index+1} ... can also use a set
        can use sliding window
        """
        if not s:
            return 0 
        
        left = 0
        longestStringLength = 0 
        hm = defaultdict()
        #iterate string
        for i in range(len(s)):
            letter = s[i]
            #if in the map.. need to determine if need to move
            if letter in hm:
                left = max(left, hm[letter])
            longestStringLength = max(longestStringLength, i - left + 1)
            #put in hm
            hm[letter] = i+1
            
        return longestStringLength