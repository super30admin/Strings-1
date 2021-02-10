# Time Complexity - O(S.length + T.length)
# Space Complexity - O(N) where N = no.of characters
# Approach : add all chars of T in hashmap, traverse the S string and if the chars of S are in hashmap add them to result according to their frequencies.
#            Also, add remaining chars in the hashmap to the result string. 


class Solution:
    def customSortString(self, S: str, T: str) -> str:
        
        if not S or len(S)==0:
            return T
        
        hashmap = {}
        res = []
        for char in T:
            if char not in hashmap:
                hashmap[char] = 1
            else:
                hashmap[char]+=1
                
        for char in S:
            if char in hashmap:
                res.append(hashmap[char]*char)
                del hashmap[char]
            
        for r_char in hashmap:
            res.append(r_char*hashmap[r_char])
            
        return "".join(res)
        