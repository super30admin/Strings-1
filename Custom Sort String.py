# Time Complexity: O(len(order) + len(s))
# Space Complexity: At worst O(26) which is constant
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        h = {}
        
        for i in s:
            if i not in h.keys():
                h[i] = 0
            h[i] += 1
        
        ans = []
        
        for i in order:
            if i in h.keys():
                for j in range(h[i]):
                    ans.append(i)
                h.pop(i)
        for i in h.keys():
            for j in range(h[i]):
                ans.append(i)
        
        return ''.join(ans)