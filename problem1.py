https://leetcode.com/problems/custom-sort-string/
#timecomplexity O(m+n) len of s and T
#spacecomlexity O(1) only small character are ther a-z

class Solution:
    def customSortString(self, S: str, T: str) -> str:
        _hashT={}
        #counting charcter in t
        res=""
        for i in T:
            if i in _hashT:
                _hashT[i]+=1
            else:
                _hashT[i]=1
        print(_hashT)
        for i in S:
            if i in _hashT:
                res+= i * _hashT[i]# mupltiply that number of times 
                del _hashT[i]
        for k in _hashT.keys():
             res+=k*_hashT[k]
            
        return res
            