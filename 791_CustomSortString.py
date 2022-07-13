class Solution:
    # Hash map Solution
    # Time Complexity: O(m+n)
    # Space Complexity: O(n) 
    # m = len(order)
    # n = len(s)
    # go over the sourse (s) string and make hash map, maintain the key = count of the each char in source
    # iterate over order, and check if the character in hashmap or not
    # if character is present, add that char on result for key(count of the each char in source) number of times and make key = 0
    # after iterating over order, add remaining charcters of source string by checking key of the charcters in hashmap
    def customSortString(self, order: str, s: str) -> str:
        hashMapDict = {}
        result = ""
            
        for i in s:
            if i not in hashMapDict:
                hashMapDict[i] = 1
            else:
                hashMapDict[i] +=1
            
        for j in order:
            if j in hashMapDict:
                curr = j*hashMapDict[j]
                result += curr
                hashMapDict[j] = hashMapDict[j] - len(curr)
        
        for j in s:
            if hashMapDict[j] != 0:
                result+= j
                
        return result