# Assign l and r to 0. Iterate through the string and store each char in  a dictionary with
# its index if the char is not present. If the character is present in the dictionary and 
# the value is greater than or equal to l, change l to d[i]+1 and change d[i] to the current index .


# Time complexity: O(n)
# Space complexity: O(1)
class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        d={}
        l=0
        r=0
        leng=0
        for  ind, i in enumerate(s):
            r=ind 
            if (i not in d):
                d[i]=ind
            else:
                if d[i]>=l:
                    l=d[i]+1
                    d[i]=ind
                else:
                    d[i]=ind
            # print(s[l:r+1])
            leng=max(r-l+1, leng)
        return leng

                

        