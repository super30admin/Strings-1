# TIme complexity - O(n)
# space complexity - O(1)
# Hashmap solution add all chars from order and then add akk other chars remaining in hmap
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        result = ''
        counter = Counter(s)
        for ch in order:
            if ch in counter:
                result += ch * counter[ch]
            del counter[ch]
        for k,v in counter.items():
            result += k * v
        return result
        
