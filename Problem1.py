class Solution:
    """
    TC - O(n)+O(m)
    SC - O(26) ~= O(1)
    """
    def customSortString(self, order: str, s: str) -> str:
        if not s:
            return ""
        hp = dict()
        for c in list(s):
            if c in hp:
                hp[c] += 1
            else:
                hp[c] = 1
        ans = []
        for c in list(order):
            if c in hp:
                for i in range(hp[c]):
                    ans.append(c)
                del hp[c]
        for c in hp:
            for i in range(hp[c]):
                ans.append(c)
        return "".join(ans)