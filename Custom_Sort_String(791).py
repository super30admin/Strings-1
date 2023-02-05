# Time Complexity: O(N)
# Space Complexity: O(N)

# Here we store all the characters in a hashmap
# then go over the order and append to the result the available characters from the hashmap
# then we append all the remaining characters to the result
class Solution:
    def customSortString(self, order: str, s: str) -> str:

        hashmap = dict()
        res = ""

        for char in s:
            if char in hashmap:
                hashmap[char]+=1
            else:
                hashmap[char]=1

        for char in order:
            if char in hashmap:
                while hashmap[char]>0:
                    res+=char
                    hashmap[char]-=1

        for key,val in hashmap.items():
            while val>0:
                res+=key
                val-=1
                hashmap[key]-=1

        return res
