# Time Complexity: O(n + m)
# Space Complexity: O(1)
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        hmap = {}
        for i in s:
            if i in hmap:
                hmap[i] = hmap[i] + 1
            else:
                hmap[i] = 1
        permutation = ""
        for i in order:
            if i in hmap:
                permutation += i * hmap[i]
                del hmap[i]
        
        # Append the remaining elements in the original order
        for key, value in hmap.items():
            permutation += key * value
        
        return permutation


