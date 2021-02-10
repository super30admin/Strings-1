"""
Time Complexity : O(n)
Space Complexity : O(n)
"""
class Solution:
    def customSortString(self, S: str, T: str) -> str:
        if not S or not T: return
        
        hashmap = {}
        for ch in T:                    # Add all char of long str to map
            if ch not in hashmap:
                hashmap[ch] = 1
            else:
                hashmap[ch] += 1
        
        newstr = ""
        for ch in S:
            if ch in hashmap:           # Some char of S might not be in T
                count = hashmap[ch]
                while count>0:
                    newstr += ch
                    count -= 1
                del hashmap[ch]
        
        for ch in hashmap:              # Take char rem in T not in S
            count = hashmap[ch]
            while count>0:
                newstr += ch
                count -= 1
        
        return newstr