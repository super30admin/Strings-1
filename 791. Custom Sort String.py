#Time Complexity:O(n)
#Space Complexity:O(n)

class Solution(object):
    def customSortString(self, order, s):
        """
        :type order: str
        :type s: str
        :rtype: str
        """
        freq={}
        for i in range(len(s)):
            freq[s[i]]=freq.get(s[i],0)+1
        result=""
        for i in range(len(order)):
            if order[i] in freq:
                times=freq.get(order[i])
                result=result+(order[i]*times)
                freq.pop(order[i])
        for ele in freq:
            result=result+freq.get(ele)*ele
        return result
        