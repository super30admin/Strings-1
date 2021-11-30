#Time O(m+n), space O(1)

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        h={}
        st=""
        #Iterate through s and store the count in hashmap
        for i in s:
            if i not in h:
                h[i]=1
            else:
                h[i]+=1
      #Iterate through order to add elements in hashmap and del key after adding          
        for j in order:
            if j in h:
                st+=h[j]*j
                del h[j]
    #Adding remaining elements of s    
        for k in h:
            st+=h[k]*k
            
        return st
