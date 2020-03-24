Brute Force:
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

optimum solution:
# TIme complexity --> o(n)
# space complexity --> o(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
we use two pointers and set to solve this problem.we traverse through the string using two pointers start and end .we increment end pointer when we are at a unique element and we add the character element to the dictionary.if duplicate element is reached then we start to shrink the window using start pointer and remove it from the dictionary.The distance between start and end pointers gives the length of the longest substring with no repeating substrings.

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        if s==None or len(s)==0:
            return 0
        start=0
        end=0
        count=0
        d=set()
        while end<len(s):
            if s[end] not in d:
                d.add(s[end])
            else:
                # print(start,end,d)
                while s[end] in d:
                    d.remove(s[start])
                    start=start+1
                continue
            count=max(count,end-start+1)
            end=end+1
        return count