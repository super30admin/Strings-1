# Custom sort string
# We are creating a hashmap to store the frequency of each character in s.
# Then we are iterating through the order string and checking if the character is in the hashmap.
# If it is, we are appending the character to the result string the number of times it appears in s.
# Finally, we are appending the remaining characters in the hashmap to the result string.
# Time complexity: O(m+n) where m is the length of order and n is the length of s.
# Space complexity: O(n)
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        freq_table = {}
        res = []
        for i in s:
            freq_table[i] = freq_table.get(i,0)+1
        for j in order:
            if j in freq_table:
                res.append(j*freq_table.pop(j)) # Appending the character to res based on its frequency and removing it from the freq_table
                #del freq_table[j]          
        for i,count in freq_table.items():
            res.append(i*count)
        return "".join(res)



        