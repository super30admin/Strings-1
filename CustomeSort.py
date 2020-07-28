class Solution:
    def customSortString(self, S: str, T: str) -> str:
        dict1={}
        for i in T:
            dict1[i]=dict1.get(i,0)+1
        
        sb=""
        for j in S:
            if j in dict1:
                cnt=dict1.get(j)
                while cnt>0:
                    sb+=j
                    cnt-=1
                del dict1[j]
        for k,v in dict1.items():
            while v>0:
                sb+=k
                v-=1
        return sb
        
#Time complexity is O(m) where m is the length of T
#Space is O(1)
