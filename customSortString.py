# Time Complexity :O((n)
# Space Complexity :O(1)
# Did this code successfully run on Leetcode :Yes       
# Any problem you faced while coding this :No

class Solution(object):
    def customSortString(self, order, s):
        """
        :type order: str
        :type s: str
        :rtype: str
        """
        result=""
        dic={}
        for i in s:
            if(i in dic.keys()):
                dic[i]+=1
            else:
                dic[i]=1
        for i in order:
            if(i in dic.keys()):
                count=dic.get(i,0)
                result=result+i*count
                del dic[i]
        for i in dic.keys():
            count=dic[i]
            result=result+i*count
        return(result)