#Time complexity: O(n)
#Space complexity: O(1)

#Accepted on Leetcode

#Approach
#Maintain a hashMap which shows the most recent occurrence index of a character
#Keep a start and endIndex which represents current substring being checked
#Iterate using the endIndex from 0 to n-1 -> whenever a currentChar is already present in the hashMap and >= startIndex -> update startIndex to the hashMap[currentChar] + 1 i.e we skip the repeating character -> Whenever this condition does not occur, we have no repetitions in current substring and we can check if the length is longest current length

class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        #max length var
        maxLength = 0
        #create hashmap
        hashMap = {}
        #iterate over s
        startIndex = 0
        for endIndex,char in enumerate(s):
            #each time check occ in hashmap along with if the occurence is within bounds
            if char not in hashMap or hashMap[char] < startIndex:
                maxLength = max(maxLength, endIndex - startIndex + 1)
            else: #repeated char
                startIndex = hashMap[char] + 1
            hashMap[char] = endIndex

        return maxLength
