# Time complexity = O(m)
# Space comnplexity = O(1) as max 26 chars
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        map = {}  # To store the chars in 's' and their frequencies
        string_builder = ""
        
        # Count the occurrences of characters in string 's'
        for i in range(len(s)):  # O(m)
            c = s[i]
            if c in map:        # Putting inside the map with their freq.
                map[c] += 1
            else:
                map[c] = 1
        
        # Append characters from 'order' in the desired order
        for i in range(len(order)): # O(n) but n can be at max 26 so constant
            c = order[i]
            if c in map:    # if c is in the map, take the count and add to the sb that many times
                count = map[c]
                string_builder += c * count
                del map[c] # Delete it from the map
        
        # Append remaining characters from 's'
        for c in map.keys():
            cnt = map[c]
            string_builder += c * cnt
        
        return string_builder
