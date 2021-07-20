# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def customSortString(self, order: str, str: str) -> str:
        #hashmap of str - char:count(char)
        
        if len(str) < 2:
            return str

        hashmap = {}

        for i in str:
            if i not in hashmap:
                hashmap[i] = 0
            hashmap[i] += 1
        out = ""
        for i in order:
            if i in hashmap:
                for j in range(hashmap[i]):
                    out += i
                del hashmap[i]
        for i in hashmap:
            for j in range(hashmap[i]):
                out += i
        return out