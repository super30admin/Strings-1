#Time Complexity :- O(m+n)
#Space Complexity :- O(s) 

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hashMap = {}
        orderedString = ''
        lastStringAdded = ''
        for i in range(len(s)):
            if s[i] not in hashMap:
                hashMap[s[i]] = 0
            hashMap[s[i]] +=1
        
        for i in range(len(order)):
            if order[i] in hashMap:
                for j in range(hashMap[order[i]]):
                    orderedString += order[i]
                    lastStringAdded = order[i]
                del hashMap[order[i]]
        for i in range(len(s)):
            if s[i] not in orderedString:
                for j in range(hashMap[s[i]]):
                    orderedString+=s[i]          
        return orderedString
