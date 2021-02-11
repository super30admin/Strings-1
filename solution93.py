#Time Complexity:O(m+n)
#Space Complexity:O(1)
class Solution:
    def customSortString(self, S: str, T: str) -> str:
        s=""                                        #output string
        if not T :                                  #if T is empty return empty string s
            return s
        dict={}                                     #declare a hash map
        for i in range(len(T)):                     #add every element of T into the hash map
            c=T[i]
            if c not in dict:
                dict[c]=0
            dict[c]+=1
        for i in range(len(S)):                     # for every element of S encountered in hashmap, reduce count by one and add to s until count is 0
            c=S[i]
            if c in dict:
                count=dict[c]
                while count>0:
                    s+=c
                    count-=1
                del dict[c]                         #remove the c character from hashmap
        for c in dict:                              #add the remaining elements in hashmap into the string the number of times if count
            count=dict[c]
            while count>0:
                s+=c
                count-=1
        return s                                    #return final output string