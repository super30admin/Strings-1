# // Time Complexity : O(n)
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : Nope


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        myset=set()
        #Slow and result
        slow=0
        res=0
        
        #Fast pointer
        for fast in range(len(s)):
            #If the character is already in the set then remove the left and 
            #increase the slow pointer
            while s[fast] in myset:
                myset.remove(s[slow])
                slow+=1
            
            #Add the fast variable
            myset.add(s[fast])
            #The result will be the maximum length of the string
            res=max(res,fast-slow+1)
            
        
        return res
                