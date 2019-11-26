# hashmap implementation
#leetcode: 791 : Successful
#Time Com = O(k) k = length of string T
#Space Com = O(1)
#Steps:
#1) Create hashmap for all chars in T
#2) Iterate over S and if present in T,add all of its occurrences to result
#3) For unmatched chars left in T,append to the result

class Solution:
    def customSortString(self, S, T):
        #edge case
        if(len(S) ==0 or len(T) ==0 or S== None or T == None):
            return T
        result = ""
        map ={}
        #1
        for t in T:
            if t not in map:
                map[t] = 1
            else:
                map[t] +=1
        #2
        for s in S:
            if s in map:
                for i in range(0,map[s]):
                    result+=s
                del map[s]
        #3
        while(len(map.keys()) !=0):
            t= list(map.keys())[0]
            for i in range(map[t]):
                result +=t
            del map[t]
        return result
obj = Solution()
pront(obj.customSortString(cba,abcd))
