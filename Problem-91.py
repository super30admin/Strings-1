'''
Leet code -791 - Custom sort string - https://leetcode.com/problems/custom-sort-string/
Time complexity - O(N)
space Complexity -O(1)

Hashmap approach

'''
class Solution(object):
    def customSortString(self, S, T):
        """
        :type S: str
        :type T: str
        :rtype: str
        """
        if not S and not T: return T
        hash={}
        for i in T:
            if i in hash:
                hash[i]=hash[i]+1
            else:
                hash[i]=1
        
        res=""
        for c in S:
            if c in hash:
                for i in range(hash[c]):
                    res=res+c
                hash.pop(c)
        for c in hash:
            for i in range(hash[c]):
                res=res+c
        return res
            