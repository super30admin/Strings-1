#time: O(n)
#space: O(1) as the size of hashmap can be at maximum a constant(total no of characters in English) 

#hashmap approach
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if(s==""):
            return 0
        hashmap={}
        start=0
        end=0
        result=0
        while(end<len(s)):
            if s[end] in hashmap:
                start=max(hashmap[s[end]]+1,start)
            hashmap[s[end]]=end
            result=max(result,end-start+1)
            end+=1
        
        return result
                
            
        