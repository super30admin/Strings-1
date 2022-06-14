# Time Complexity : O(N) where N is length of the string
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hashmap = {}
        result = []
        for i in range(len(s)):
            if s[i] not in hashmap:
                hashmap[s[i]] = 1
            else:
                hashmap[s[i]] += 1
                
        for j in range(len(order)):
            if order[j] in hashmap:
                result.append(order[j] * hashmap[order[j]])
                hashmap.pop(order[j])
            
        for letter, count in hashmap.items():
            result.append(letter * count)

        return "".join(result)