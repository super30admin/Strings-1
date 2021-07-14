class Solution:
    def customSortString(self, order: str, str: str) -> str:
        hashMap = {}
        result = ""
        for x in str:
            if x in hashMap:
                hashMap[x] += 1
            else:
                hashMap[x] = 1
        for i in order:
            if i in hashMap:
                while hashMap[i] > 0:
                    result += i
                    hashMap[i] -=1
                hashMap.pop(i)
        
        for key in hashMap.keys():
            while hashMap[key] > 0:
                result += key
                hashMap[key] -= 1
        
        return result

#Time complexity is O(N) N -> elements in the str string
#Space complexity is O(1) 