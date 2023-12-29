'''The code customizes the sorting of characters in the string 's' based on the order provided in the 'order' string. 
It uses a dictionary (char_map) to count the frequency of each character in 's' and then builds the result string by appending characters according to the specified order.
Finally, it includes the remaining characters from 's' that were not in the order.

Time complexity: O(m + n) - The algorithm iterates through each character in 's' and 'order'.
Space complexity: O(m) - The space used by the char_map, where 'm' is the length of the input string 's'.'''
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        char_map = {}
        result =[]
        for i in s:
            char_map[i] = char_map.get(i, 0) + 1

        for i in order:
            if i in char_map:
                freq=char_map.get(i)
                result.extend([i] * freq)
                del char_map[i]

        for k in char_map:
            freq=char_map.get(k)
            result.extend([k] * freq)

        return ''.join(result)


            
        