# Time Complexity = O(m + n)
# Space Complexity = O(1)


class Solution:
    def customSortString(self, order: str, s: str) -> str:
        if len(order) == 0:
            return s
        
        # Hashmap initialisation
        hashMap = {}
        
        # Record the number of occurences of each char in s, in the hashmap
        for i in range (len(s)):
            char = s[i]
            if char not in hashMap:
                hashMap[char] = 1
            else:
                hashMap[char] += 1
        
         
        # result string
        strR = ""
        
        # Iterate over order, check its availability in map, append that many times to result str
        for i in range(len(order)):
            char = order[i]
            if char in hashMap:
                num = hashMap[char]
                strB = "". join([char for j in range(num)])
                strR = strR + strB
                hashMap.pop(char)
        
        
        # If hashmap is not empty post iteration over order elements, add the remaining chars
        if len(hashMap) != 0:
            for char in hashMap:
                num = hashMap[char]
                strB = "".join([char for j in range(num)])
                strR = strR + strB
                
                
        return strR