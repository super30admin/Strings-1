#Accepted on leetcode
#Time complexity - O(N+M) where N is len of S and M is len of T
#Space omplexity - O(N) use of hashmap

class Solution(object):
    def customSortString(self, S, T):
        """
        :type S: str
        :type T: str
        :rtype: str
        """
        #Edge case
        if S == None or len(S) == 0 or T == None or len(T) == 0:
            return ""            
        #Logic
        hash_ = {}
        s = []
        s.extend(S)
        for i in range(0,len(s)):
            hash_[s[i]] = i
            print(hash_)
        t = []
        t.extend(T)
        for j in range(len(t)):
            if hash_.has_key(t[j]):
                ind = hash_[t[j]]
                t[j], t[ind] = t[ind], t[j]
        return "".join(t)