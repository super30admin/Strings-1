#Time complexity: O(m + n)
#Space complexity: O(n) to store the computed string's intermediate representation

#Accepted on Leetcode

#Approach
#Compute frequency count of unordered string using a hashMap
#Iterate through ordered string and add each string (into soln string) as many times as it's frequency in the hashmap (and remove them from hashMap)
#Add remaining strings in hashMap arbitrarily to end of solnString


class Solution:
    def customSortString(self, order: str, s: str) -> str:
        #compute frequency count
        hashMap = {}
        for char in s:
            if char not in hashMap: 
                hashMap[char] = 0
            hashMap[char] += 1

        #compute soln
        solnStringList = []
        for char in order:
            if char in hashMap:
                count = hashMap[char]
                for i in range(count):
                    solnStringList.append(char)
                del hashMap[char]

        #Add unordered chars at the end
        for char in hashMap:
            count = hashMap[char]
            for i in range(count):
                solnStringList.append(char)


        return ''.join(solnStringList)