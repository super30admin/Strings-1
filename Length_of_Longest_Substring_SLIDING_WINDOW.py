# Created by Aashish Adhikari at 7:29 PM 2/9/2021
'''
Time Complexity:
O(n)

Space Complexity:
O(1)
'''


class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """

        if s == "":
            return 0

        hm = {}

        p1 = 0

        import sys
        maxx = -sys.maxsize

        for p2 in range(0, len(s)):

            c = s[p2]


            if c not in hm:

                maxx = max(maxx,p2-p1+1)

                hm[c] = p2
            else:

                p1 = max(p1, hm[c]+1)

                maxx = max(p2-p1+1, maxx)
                hm[c] = p2



        return maxx
