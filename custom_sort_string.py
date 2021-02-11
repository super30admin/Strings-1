# Time Complexity: O(m+n)
# Space Complexity: O(1) worst case length of hash_map will be 26, hence O(1)
# Accepted on Leetcode, faster than 99%
class Solution:
    def customSortString(self, S: str, T: str) -> str:
        result = ""
        hash_map = defaultdict(int)
        for c in T:
            hash_map[c] += 1
        
        for c in S:
            if c in hash_map:
                result += c*hash_map[c]
                del hash_map[c]
        
        for key in hash_map:
            result += key*hash_map[key]
                
        return result
        