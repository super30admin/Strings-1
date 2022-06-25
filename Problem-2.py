class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        #null check
        if not s or len(s)==0:
            return 0
        #initialzations
        hashmap={}
        start=end=0
        maximum=float('-inf')
        #start slinding window
        while end<len(s):
            char=s[end]
            if char in hashmap and hashmap[char]>start:
                start=hashmap[char]
            
            hashmap[char]=end+1
            #calculate max window size
            maximum=max(maximum,end-start+1)
            
            end+=1
            
        return maximum
        
            
        