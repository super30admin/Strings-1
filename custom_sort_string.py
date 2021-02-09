# Approach: Store the frequency of characters in the hashmap
# Iterate over the string S which has the pattern of string, and if characters of S are in hashmap get their freq and add that many characs to result
# Iterate over remaining characters in hashmap and add to result

# Time - O(M + N) Iterating over both string S(for pattern) and T(for creating hashmap)
# Space - O(N) where N is the number of characs in string T stored in result/string builder
# Space for hashmap not considered as its a constant with 26 characs

class Solution:
    def customSortString(self, S: str, T: str) -> str:
        
        if not S or len(S) == 0:
            return T
        
        hashmap = {}
        result = []
        
        for char in T:
            if char not in hashmap:
                hashmap[char] = 1
                
            else:
                hashmap[char] += 1
                
        for char in S:
            if char in hashmap:
                result.append(char * hashmap[char])
                del hashmap[char]
                   
        for remaining_char in hashmap:
            result.append(remaining_char * hashmap[remaining_char])
            
            
        return "".join(result)
                
        