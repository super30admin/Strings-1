class Solution:
    # Time Complexity - O(M+N)
    # Space Complexity - O(N)
    # M is len(S) and N is len(T)
    # Use a hashmap to store the count of alphabets that are in "S"
    # Later iterate through hashmap and add each element the value number of times to output
    # Next we will add the remaining items in the hashmap to the output
    def customSortString(self, S, T):
        hashmap = {}
        res = ""
        for ch in T:
            if ch not in hashmap:
                hashmap[ch] = 0
            hashmap[ch] += 1
            
        for c in S:
            if c in hashmap:
                val = hashmap[c]
                while val:
                    res += c
                    val -= 1
                del hashmap[c]
        for k, v in hashmap.items():
            while v:
                res += k
                v -= 1
        return res
            
        