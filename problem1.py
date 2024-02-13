#Time Complexity : O(n+m)
#Space Complexity :O(n)
#Did this code successfully run on Leetcode : yes

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hash_map = {}

        for c in s:
            hash_map[c] = hash_map.get(c,0)+1

        result = []

        for c in order:
            if c in hash_map:
                count = hash_map[c]
                for _ in range(count):
                    result.append(c)
                del hash_map[c]
            
        
        for c in hash_map.keys():
            count = hash_map[c]
            for _ in range(count):
                result.append(c)

        return ''.join(result)

        