# APPROACH  
# Time Complexity : O(t), t: len(T) (S is guranteed to have unique chars, so at the max length 26)
# Space Complexity : O(1), (hashmap will have at the max 26 entries only)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : None
#
#
# Your code here along with comments explaining your approach
# 1. Store the frequency of all chars of T in hashmap
# 2. Go through each char in S and check if in hashmap or not. If present, add that many times as it appears in T in result string
# 3. Add all other chars of T not present in S to result string (it's order doesn't matter)

class Solution:
    def customSortString(self, S: str, T: str) -> str:
        if S is None or T is None:
            return None           
            
        hashmap_T = defaultdict(int)
        for char in T:
            hashmap_T[char] += 1
            
        result = []
        for char in S:
            if char in hashmap_T:
                while hashmap_T[char] > 0:
                    result.append(char)
                    hashmap_T[char] -= 1
                del hashmap_T[char]
                
        for char in hashmap_T:
            while hashmap_T[char] > 0:
                result.append(char)
                hashmap_T[char] -= 1
            
        result_str = "".join(result)
        
        return result_str
        
