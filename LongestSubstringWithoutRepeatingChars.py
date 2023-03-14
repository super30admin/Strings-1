#All TC passed on leetcode

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:

        #Two pointer approach. Here s is traversed and each distict char is stored in map with its coressponding index value. If cur jth char is present in map then i is moved to char's index+1 position and res is recorded for each iteration as length b/w i and j.
        #Time complexity - O(n) - where n is length of string 
        #Space complexity - O(1) - dict can have only fixed values
        i=0
        j=0

        dict = {}
        res = 0

        while j<len(s):
            if s[j] in dict:
                i = max(i, dict[s[j]]+1)
            dict[s[j]] = j
            res = max(res, j-i+1)
            j+=1
        return res
        