# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : yes

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        # output string
        sout = ''
        count = 0

        # iterate though the order
        for sortletter in order:

            # check if sortletter is in s, add to output var
            count = s.count(sortletter)

            if count > 0:
                sout = sout + sortletter * (count)

                # remove the letter from s
                s = s.replace(sortletter, '', count)

            count = 0
        return(sout + s)
