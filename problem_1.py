# TC: O(m(Counter f(n)) + n + m) -> n == len(order) == constant -> O(2m) m = len(s) == O(m)
# SC: O(m) len of s

from collections import Counter

def customSortString(order: str, s: str) -> str:
    d = Counter(s)
    r = ''
    for c in order: 
        if c in d:
            r += c * d[c]
    
    for c in s:
        if c not in order:
            r += c
    return r