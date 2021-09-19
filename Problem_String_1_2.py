class Solution:



    def lengthOfLongestSubstring(self, s: str) -> int:




        res = 0



        slow = 0



        fast = 0



        chardict = dict()



        while fast < len(s):



            if s[fast] in chardict:



                slow = max(slow, chardict[s[fast]])



            chardict[s[fast]] = fast + 1



            res = max(res, fast - slow + 1)



            fast += 1



        return res


#TC : O(n)
#SC : O(n)