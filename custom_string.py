# Time Complexity :
# O(N) - length of string s

# Space Complexity :
# O(1)

# Did this code successfully run on Leetcode :
#Yes

#Create a frequency map of the string s. For every character in order, we add that character based on it's frequency in the return string. Once we are done processing all the characters in the order string, we add the rest of the characters from the frequency map originally created

class Solution:
    def customSortString(self, order: str, s: str) -> str:
        custom_freq_map = {}
        return_str = ''
        for char in s:
            if char in custom_freq_map :
                custom_freq_map[char] += 1
            else :
                custom_freq_map[char] = 1

        for char in order:
            if char in custom_freq_map:
                return_str += char * custom_freq_map[char]
                del custom_freq_map[char]

        for key,value in custom_freq_map.items():
            return_str += key * value
            
        return return_str
