#Time: O(n)
#Space: O(n)
#Program ran on leetcode successfully

class Solution(object):
    def customSortString(self, order, s):
        """
        :type order: str
        :type s: str
        :rtype: str
        """
        countMap = {}
        for i in range(len(s)):
            if (s[i] not in countMap):
                countMap[s[i]] = 1
            else:
                countMap[s[i]] = countMap[s[i]] + 1
        
        retStr = ""
        for j in range(len(order)):
            c = order[j]
            if (c in countMap):
                count = countMap[c]
                for i in range(count):
                    retStr += c
                del countMap[c]
        
        for c in countMap:
            count = countMap[c]
            for i in range(count):
                retStr += c
        
        return retStr
                
        
        
        