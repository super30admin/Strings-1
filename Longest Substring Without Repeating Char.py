#  Longest Substring Without Repeating Characters
class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        leftchar=rightchar=maxlength=0
              
        stringset= set()
        
        for rightchar in range(len(s)):
            while s[rightchar] in stringset:
                
                stringset.remove(s[leftchar])
                
                leftchar = leftchar + 1
                
            
            stringset.add(s[rightchar])
            
            maxlength=max(maxlength, rightchar-leftchar+1)
            
        return maxlength
        