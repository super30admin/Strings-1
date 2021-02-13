# Created by Aashish Adhikari at 6:53 PM 2/8/2021

'''
Time Complexity:
O(n^2) where n is the length of the input string.

Space Complexity:
O(n^2) as we store all the characters encountered for each character in the string.


'''

class Solution(object):

    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """

        if s == "":
            return 0
        import sys
        maxx = -sys.maxsize

        for idxx in range(len(s)):
            hs = set()
            ctr = 0

            for idx in range(idxx, len(s)):
                if s[idx] not in hs:
                    ctr += 1
                    hs.add(s[idx])
                else:
                    maxx = max(maxx, ctr)
                    break
            # if reach the end for this character
            maxx = max(maxx, ctr)


        return maxx

