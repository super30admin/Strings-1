#Time Complexity : O(n) ... where n is the length of the string
#Space Complexity : O(n) ... where n is the length of the permutated string
#Any problem you faced while coding this : -

# Used the hashmap to maintain the frequency of the characters in the string. While building the permutated string, the initial append was done based on the given sorted order substring and then the remaining characters were appended.

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        map = {}
        for i in range(len(s)):
            if s[i] not in map.keys():
                map[s[i]] = 1
            else:
                map[s[i]] += 1

        sb = ""

        for o in range(len(order)):
            if order[o] in map.keys():
                count = map[order[o]]
                for c in range(count):
                    sb += order[o]
                map.pop(order[o])

        for k,v in map.items():
            count = v
            for i in range(count):
                sb += k

        return sb