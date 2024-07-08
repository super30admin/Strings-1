"""
Time Complexity - O(max(m,n)) m is the length of order string and n is the length of the given string
Space Complexity = O(n)

Works on Leetcode
"""
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hashMap = {}
        #store all character in given string with frequencu in a hashMap
        for c in s:
            hashMap[c] = hashMap.get(c, 0) + 1
        result = ""
        #traverse the order string and create the resultant string by adding the characters of candidate string in the order mentioned.
        for c in order:
            if c in hashMap:
                cnt = hashMap[c]
                while cnt >0:
                    result +=c
                    cnt-=1
                hashMap.pop(c)

        #append all characters not in the order.
        for c in hashMap.keys():
            cnt = hashMap.get(c)
            while cnt > 0:
                result+=c
                cnt-=1
            # hashMap.pop(c)
        return result
