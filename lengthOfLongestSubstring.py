# TimeComplexity:O(N)
# SpaceComplexity:O(1)
# Approach: 
#   BruteForce: Get all combiantions of substring and check if it is valid or not O(n^3).
#   can we stop if have 2 duplicate chars?? yes that can be done with 2 pointers
#   2pointer + set: have 2 pointers left and right keeping on adding into set untill you see duplicate (why set O(1) serach).if find any dupliacte remove charters from l to r untill no duplicats O(2*n)
#   2pointers+map: Instead of moving l pointer all the way can we directly jump ?yes we can with hashmap. while traversing add idx of each element if already in hashmap
#   update ans if prev idx >left 






class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        #2pointers with hashmap 
        # note idxs, comapre with left pointer , update in hashmap cOMPLEXIY oN,1
        map_idx=dict()
        ans=0
        if len(s)<=1:return len(s)
        map_idx[s[0]]=0
        l=0
        for r in range(1,len(s)):
            if s[r] not in map_idx:
                ans=max(ans, r-l+1)
                map_idx[s[r]]=r
            elif s[r] in map_idx:
                l=max(map_idx[s[r]]+1,l)
                map_idx[s[r]]=r
                ans=max(ans, r-l+1)
        ans=max(ans, r-l+1)
        return ans


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # this has 3 methods brute force n^3 , 2pointer with set and 2pointer with map

        #2pointer with set , complexity is O(2n,1)..2n because a-uniqueletters-a..worst case
        visted=set()
        ans=0
        if len(s)<=1:return len(s)
        l=0
        
        visted.add(s[0])
        for r in range(1,len(s)):
            
            if s[r] not in visted:
                ans=max(ans, r-l+1)
                visted.add(s[r])
            elif s[r] in visted:
                
                while(s[r] in visted):
                   
                    visted.remove(s[l])
                    l+=1
                visted.add(s[r])
                ans=max(ans, r-l+1)
           
        ans=max(ans, r-l+1)
        return ans
                
