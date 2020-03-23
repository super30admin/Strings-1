// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
try to include the unique characters in out string while traversing and store the count of out.when any repating character is encountered then we make out to None.we do this process till we reach the end of the string and maxi gives the length of the maximum length of the longest substring without repeating characters.

# Time complexity --> o(n*n)
# space complexity --> o(n)
class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        out=''
        i=0
        maxi=float('-inf')
        c=0
        while(i<len(s)):
            if s[i] not in out:
                out=out+s[i]
                c=c+1
            else:
                i=s.index(s[i])
                s=s[i+1:]
                maxi=max(maxi,c)
                out=''
                c=0
                i=-1
            i=i+1
        return max(maxi,c)
        