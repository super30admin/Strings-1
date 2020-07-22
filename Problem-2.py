# Time Complexity :if two arrays sorted average O(n)
# Space Complexity :O(1) 
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : no
class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        if not s:
            return 0
        # to know chars that is in substring
        helper = set()
        # length of longest substring found till now
        sol = 0
        #two pointers for  sliding window
        pointerbeg = 0
        pointerend = 0
        # loop until end of string
        while pointerend < len(s):
            # if this is a unique letter add it to helper and increase size of sol if it is larger than old sol
            if s[pointerend] not in helper:
                helper.add(s[pointerend])
                sol = max(sol,(pointerend - pointerbeg + 1))
                pointerend +=1
            else:
                # else till you find the repeated char remove all chars you see from helper
                while s[pointerbeg] != s[pointerend]:
                    helper.remove(s[pointerbeg])
                    pointerbeg+=1
                # remove the repeated char itself
                if s[pointerbeg] == s[pointerend]:
                    helper.remove(s[pointerbeg])
                    pointerbeg+=1
        # return sol
        return sol