"""
The approach here is to maintain two hashmaps and keep the count of those characters, and now iterate over 
the keys of s first and for keys in s decrement the particular value keys in dict of T, finally if chars in
s are present in t then the values will be non -1 thus we will add those values to the result string and
lastly we all the chars in t which are not in s at the end.
Space complexity - O(N)
Time complexity - O(N^2)
Leetcode - running
"""

def customSortString(self, S: str, T: str) -> str:
    result = ''
    s = {}
    for i in S:
        s[i] = 1
    t = {}
    for i in T:
        t[i] = t.get(i,0) + 1
        
    for i in s.keys():
        bi = t.get(i,-1)
        if bi != -1:
            result += (i*bi)
            t[i] = 0
    for i in t.keys():
        if t[i] != 0:
            result += (i*t[i])
    return result
