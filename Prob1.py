from collections import Counter
class Solution(object):
    def customSortString(self, order, str):
        """
        :type order: str
        :type str: str
        :rtype: str
        """
        if str is None:
            return ''
        res = []
        countMap = dict(Counter(str))
        #take all elements in the order string and use all instances to make one string
        for ch in order:
            if ch in countMap:
                ct = countMap[ch]
                tempRes = ct * ch
                res.append(tempRes)
                del countMap[ch]
        # for remaining characters, just append it 
        for ch,ct in countMap.items():
            tempRes = ct * ch
            res.append(tempRes)
        
        return ''.join(res)

        
