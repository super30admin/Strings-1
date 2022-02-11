"""
Time: O(N) N = length of M + N
space: O(N)
works on leetcode
"""

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        cnt = Counter(s)
        ans = []
        for c in order:
            if cnt[c] > 0:
                ans.append(cnt[c] * c)
                cnt.pop(c)
        for i in cnt:
            ans.append(i * cnt[i])
        return "".join(ans)