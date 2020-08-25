class Solution:
    def customSortString(self, S: str, T: str) -> str:
        count = collections.Counter(T)
        print(count)
        ans = []
        for c in S:
            ans.append(c*count[c])
            count[c]=0
        for c in count:
            ans.append(c*count[c])
        return "".join(ans)
#Time-complexity:O(n+m)
#Space-complexity:O(m)