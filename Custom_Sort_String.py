from collections import Counter
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        """
        Time Complexity: o(m+n)
        Space Complexity: O(1)
        """
        hash_ = Counter(s)
        final = ''
        for char in order:
            if hash_.get(char):
                while hash_[char] != 0:
                    final += char
                    hash_[char] -= 1
            
                
        for key,val in hash_.items():
            if val != 0:
                while val != 0:
                    final += key
                    val -= 1
            
        return final
                
                
        