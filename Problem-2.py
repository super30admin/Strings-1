#Approach
# find the frequencies of the order and form te new string with the string and add the reaining elemnets in string to form the resultant


#Complexities
#Time: O(N)
#SpaceO(N)



class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hashMap = {}
        result = ""
        for char in s:
            if char not in hashMap:
                hashMap[char] = 0
            hashMap[char] += 1

        for char in order:
            if char in hashMap:
                result += char * hashMap[char]
                del hashMap[char]

        for char in hashMap:
            result += char * hashMap[char]
        return result
