"""
Approach: Using a hashmap

We use hashmap where we will first store the frequency of every unique character in string T

Now we will iterate over S, check for the character in T. If its present then add that character its frequency times into the resultant string. Also remove the the character from the hashmap.

Now iterate over the remaining keys in hashmap and add them its frequency times into the resultant string.

Example:
S = "cba"
T = "abcd"

hashmap = {a:1, b: 1, c: 1, d:1}
Time complexity: O(m + n)
Space complexity: O(1); because hashmap will contain at the most 26 letters as keys

where m and n are lengths of strings S and T.
"""

from collections import Counter
class Solution:
    def customSortString(self, S: str, T: str) -> str:
        if T == None or len(T) == 0:
            return ""
        
        count = Counter(T) # O(n)
        
        result = ""
        
        for i in S: # O(26) in worst case
            if i in count:
                result += (i * count[i]) # Here count may not be the same for every character. So it can not be O(m x n)
                del count[i]
                
        
        for key in count.keys():
            result += (key * count[key])
            
        return result