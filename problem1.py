#time O(N)
#space O(N)

def customSortString(self, S: str, T: str) -> str:
    ans = ""
    for i in S:
        if i in T:
            ans += (i * T.count(i)) # counts no. of times i occurs in T and adds that many i to ans
            T = T.replace(i, '') # replaces all occurrences of i in T with '', so it doesn't repeat
    return ans+T