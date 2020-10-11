# Time - O(N)
# space- O(N)
# Using hashset and storing count 



class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        hashset = set()
        result = 0
        i = 0
        j = 0
        
        
        while i < len(s) :
            if s[i] not in hashset:
                hashset.add(s[i])
                i += 1
                
            else:
                hashset.remove(s[j])
                j += 1
            result = max(result, i-j)
            
        return result
    
