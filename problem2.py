from collections import defaultdict
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        #Approach we will keep track of index
        start=0
        end=0
        store=defaultdict(int)
        maxs=0
        while(end<len(s)):
            if (s[end] in store) and (store[s[end]]>=start):
                
                start=store[s[end]]
            
            maxs=max(maxs,end-start+1)
            store[s[end]]=end+1
            
            end+=1
        return maxs
        #Time O(n)
        #Space O(n)
        
        
#Approach 2, Time Complexity O(2n)        
#         start=0
#         end=0
#         store=defaultdict(int)
#         maxs=(0,"")
#         while(end<len(s)):
#             store[s[end]]+=1
#             while(start<end and store[s[end]]>1):
#                 store[s[start]]-=1
#                 if store[s[start]]==0:
#                     del store[s[start]]
#                 start+=1
           
#             if maxs[0]<len(s[start:end+1]):
#                 maxs=(len(s[start:end+1]),s[start:end+1])
#             end+=1
#         return maxs[0]
