# Leetcode execution : YES
# Time complexity:O(n)
# Space Complexity: O(1) since only 26 characters for lower letters alphabet
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        count=0
        slow=0
        fast=0
        mapping={}
        # we have slow and fast pointer at 0 initially abd we make use of sliding window approach in this problem set, we loop until fast is == to len(s) 
        while(fast<len(s)):
            # check if the fast is in the mapp
            if s[fast] in mapping:
            # then current slow or basically slow 
                # if it is then we need to use move the slow which is higher 
                slow=max(mapping[s[fast]]+1, slow)
                
            # we count the max length with prev count and fast-slow +1 
            count=max(fast-slow+1,count)
            # we reassign the new position of the fast character to the curretn fast index
            mapping[s[fast]]=fast
            # every step we are moving fast + 1
            fast+=1
        return count