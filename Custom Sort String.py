"""
Leetcode question: https://leetcode.com/problems/custom-sort-string/


Approach:
Iterate over str string and store all numbers and their occurances as key:value pair in hashmap.
Iterate over order string and append all characters in result string from the hashmap for number of
times they occurred in hashmap
Append remaining characters of str from hashmap to result string

Time Complexity: O(m+n)
Space Complexity: O(n)
"""
class Solution:
    def customSortString(self, order: str, str: str) -> str:
        if order==0 or str==0 or len(order)==0 or len(str)==0:
            return self.result

        self.result =""
        count=0

        hashmap={} #char and int

        for i in range(len(str)):
            if str[i] in hashmap:
                hashmap[str[i]]+=1
            else:
                hashmap[str[i]]=1


        print(hashmap)

        for j in range(len(order)):
            if order[j] in hashmap:
                while hashmap[order[j]]>0:
                    #result+=hashmap[order[j]]
                    self.result+=order[j]
                    hashmap[order[j]]-=1


        for key in hashmap:
            while(hashmap[key] > 0):
                self.result += key
                hashmap[key] -= 1

        return self.result

s=Solution()
print(s.customSortString("cba" ,"abcd"))









