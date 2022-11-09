'''
Time Complexity: O(m+n)
Space Complexity: O(1)
'''
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        result = ""
        hashmap = {}
        for i in range(len(s)):
            if(s[i] in hashmap):
                hashmap[s[i]] = hashmap[s[i]] + 1
            else:
                hashmap[s[i]] = 1
        #print(hashmap)
        for i in range(len(order)):
            if(order[i] in hashmap):
                while(hashmap[order[i]]>0):
                    result = result + order[i]
                    hashmap[order[i]] -= 1
        for i in hashmap.keys():
            while(hashmap[i]>0):
                result = result+i
                hashmap[i] -= 1 
        return result        