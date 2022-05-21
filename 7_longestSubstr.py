class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        x = [char for char in s]
        if s==None: 
            return 0 
        if len(x)==0:
            return 0
        if len(x) ==1:
            return 1
        num_unique = len(set(x)) #; print("Unique =", num_unique)
        charMap ={} ; 
        
        i = -1;  slow = 0; fast = 0 ;  maxLen = 1
        for c in x:
            i +=1 
            if c in charMap: 
                prev = charMap[c]; 
                if prev >= slow:
                    slow = prev+1 ; #print(prev)
                maxLen = max(maxLen, i-slow+1)  ;# print(i, slow,maxLen, "f")
                charMap[c] = i 
            else:
                charMap[c] = i
                maxLen = max(maxLen, i-slow+1) ;# print(i, slow,maxLen, "n")
            if maxLen == num_unique:
                return maxLen
        return maxLen 