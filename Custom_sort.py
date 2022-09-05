# Time complexity : O(2*n)
# Space complexity : O(1)
# Leetcode : Solved and submitted

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        # maintain a hashmap for frequency count
        seen = {}
        
        # add the frequency of characters from string s to the hashmap
        for ch in s:
            if ch not in seen:
                seen[ch] = 1
            else:
                seen[ch] += 1
        
        # result is an empty string
        res = ''

        # traversing over the order string, check for each character, fetch the freq of that from the map
        # then add that many characters to the result preserving the order
        for ch in order:
            if ch in seen:
                count = seen[ch]
                for i in range(count):
                    res += ch
                # delete the keys which are added to the resultant
                del seen[ch]
        
        # after going over the order, if there are any keys left in the map, traverse over them in any order, and add it to the res
        for key in seen:
            count = seen[key]
            for i in range(count):
                    res += key
        
        return res
