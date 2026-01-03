
# Loop through the string s and create a frequesncy map. Loop through order and 
# check if the char exists in the frequesncy map, if it does, append the char to the frequesncy
# no. of times to the final string and then remove the key from d. If there are char remaining in 
# d, then append them to the final string

# Time complexity: O(n)
# Space complexity: O(1)

class Solution(object):
    def customSortString(self, order, s):
        """
        :type order: str
        :type s: str
        :rtype: str
        """
        fstr=""
        d={}
        for i in s:
            if i not in d:
                d[i]=1
            else:
                d[i]=d[i]+1
        for i in order:
            if i in d:
                fstr=fstr+(i*d[i])
                d.pop(i)
        for i in d:
            fstr=fstr+i*d[i]
        return fstr

        