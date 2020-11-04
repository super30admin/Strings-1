class Solution:
    def customSortString(self, S: str, T: str) -> str:
        
        result = []
        hmap = {}
        res = ''  
        
        # Iterate T to calculate frequency
        
        for i in T:
            if i not in hmap:
                hmap[i]=1
            else:
                hmap[i]+=1
                
        # Iterate S
        
#         for ch in S:
#             freq = hmap[ch]
            
#             while freq>0:
#                 result.append(ch)
#                 freq-=1
                
#         hmap.pop(ch)

   
		
		# follow the order of S to rebuild the string in res
        for i in range(0,len(S)):
            if S[i] in hmap:
                res += S[i] * hmap[S[i]]
                hmap[S[i]] = 0 
				
        #add the rest chars in T from dictionary
        for key, value in hmap.items():
            if value != 0:
                res += key * hmap[key]
        
        return res

#Time Complexity: O(N+M)
#Space Complexity: O(N)