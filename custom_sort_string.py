#Time-Complexity = O[m+n]
#Space-Complexity = O[n]
class Solution(object):
    def customSortString(self, S, T):
        """
        :type S: str
        :type T: str
        :rtype: str
        """
        if T is None:
            return
        if S is None:
            return T
        s = ''
        hashmap = {}
        for i in T:
            if i not in hashmap:
                hashmap[i]=1
            else:
                hashmap[i]+=1
        for j in S:
            if j in hashmap:
                s+=j*hashmap[j]
            hashmap[j]=-1
        for key in hashmap:
            if hashmap[key]!=-1:
                s+=hashmap[key]*key
        return s
            
        