"""791. Custom Sort String
Time Complexity:O(n)
Spce Complexity:O(n) n -> length of string"""
class Solution:
    def customSortString(self, order: str, str: str) -> str:
        if str is None or len(str)==0:
            return 0
        hashmap= collections.Counter(str)
        result = []
        
        for c in order:
            if c in hashmap:
                result.append( c * hashmap[c])
                del hashmap[c]
        
        for c in hashmap:
            result.append(c * hashmap[c])
        print(result)
            
        return "".join(result)
            