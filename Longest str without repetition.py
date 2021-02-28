# // Time Complexity : O(n)
# // Space Complexity : O(1) as max hashmap can be 26 
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# We use the hashmap and two pointers here: chars as key and index as value
# if the char is already in hashmap then we do:
# 1. update the value of the key and 
# 2. update the start index to max(index, hashmap[end]+1)
# if not in hashmap we simply put it
# for each iteration we calculate max by max(max, end-start+1)

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 0: return 0
        hashmap = {}
        start = 0
        end = 0   
        maximum = 0
        # end pointer will move for each iteration || start will move only if we have repeted char
        for end in range(len(s)):
            if s[end] not in hashmap:
                hashmap[s[end]] = end
            else:
                # we found repetation
                start = max(start, hashmap[s[end]]+1)
                hashmap[s[end]] = end
                # update maximum 
            if end-start+1 > maximum:
                l=[]
                l.append(s[start:end+1])
                maximum = end - start+1
            elif end-start+1 == maximum:
                l.append(s[start:end+1])
                
                    
        print(l)  
        return maximum
    
