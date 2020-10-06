from collections import defaultdict
class Solution:
    def customSortString(self, S: str, T: str) -> str:
        
        #Time: O(S+T)
        #Space: O(T)
        H = defaultdict(int)
        Sol = ''
        
        #Add elements in T to dictionary
        for i in T:
            H[i]+=1
        
        #Add each element from S in Dictionary (count times) to sol, remove in dictionary
        for i in S:
            count = H[i]
            while count>0:
                Sol+=i
                count-=1
            del H[i]
        
        #Add remaining elements from Dictionary not in S to Sol
        for i in H:
            count = H[i]
            while count>0:
                Sol+=i
                count-=1
        return Sol