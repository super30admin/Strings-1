# TC: O(M + N)
# SC: O(1) 

# create counter hashmap of T chars (longer string), Iterate over S and check for char in hashmap: If there, append result string builder with count times char and delete entry from hashmap. At the end, append rest over elements.
from collections import Counter
class Solution(object):
    def customSortString(self, S, T):
        hashmap = Counter(T)
        result = []
        for char in S:
            if char in hashmap:
                result.append(char * hashmap[char])
                del hashmap[char]
        for char in hashmap:
            result.append(char * hashmap[char])
        return "".join(result) 