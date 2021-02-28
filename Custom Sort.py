# // Time Complexity : 
# // Space Complexity : O(n)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach
# We use hashmap to store the T chars 
# we iterate over the S
# and make new string with all chars from the hashmap and S 

class Solution:
    def customSortString(self, S: str, T: str) -> str:
        hashmap = {}
        for i in T:
            if i not in hashmap:
                hashmap[i] = 0
            hashmap[i] += 1
        res = ''
        # iterate over S
        for i in S:
            # find chars that are in HashMap and its count, that many times append 
            if i in hashmap:
                times = hashmap[i]
                for j in range(times):
                    res += i
                del hashmap[i]
        # append remaining elements from hashmap
        for i in hashmap:
            times = hashmap[i]
            for j in range(times):
                res += i
            # del hashmap[i]
        return res
        
            
            
            
        