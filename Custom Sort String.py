#time: O(n) where n is the length of string T as length of string S is constant
#space: O(1)

class Solution:
    def customSortString(self, S: str, T: str) -> str:
        if(S==""):
            return T
        hashmap={}
        result=""
        c=0
        for j in T:
            if j in hashmap:
                hashmap[j]+=1
            else:
                hashmap[j]=1

        for i in S:
            if i in hashmap:
                for j in range(hashmap[i]):
                    result+=i
                hashmap.pop(i)
        for i in hashmap:
            for j in range(hashmap[i]):
                    result+=i
        return result
            