#leetcode 791 https://leetcode.com/problems/custom-sort-string/
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        lookup = defaultdict(int)
        i = 0
        for c in order:
            lookup[c] = i
            i += 1
        print (sorted(s, key=lambda x:lookup.get(x,100)))
        return "".join(sorted(s, key=lambda x:lookup.get(x,100)))
                