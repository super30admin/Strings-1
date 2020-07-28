class Solution:
    def lengthOfLongestSubstring(self, s):
        i=j=0
        set1=set()
        maxlength=0
        while(j<len(s)):
            if s[j] not in set1:
                set1.add(s[j])
                 #j goes to next index which can be in the set or not
                maxlength=max(maxlength,j-i+1)
                j+=1
            else:
                set1.remove(s[i])
                i+=1
        return maxlength  
        
Time Complexity is O(2n)
Space Complexity is O(n)
