#Time:O(n)
#space:O(n)
from functools import cmp_to_key
from collections import defaultdict
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        char_count = defaultdict(int)
        for char in s:
            char_count[char]+=1
        ans_list = []
        for char in order:
            ans_list.append(char*char_count[char])
            char_count[char]=0
        
        for char in char_count:
            if char_count[char]:
                ans_list.append(char*char_count[char])
        return "".join(ans_list)
            