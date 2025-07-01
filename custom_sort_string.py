#Time Complexity: O(N)
#Space Complexity: O(1)
class Solution(object):
    def customSortString(self, order, s):
        """
        :type order: str
        :type s: str
        :rtype: str
        """
        frequency_map = {}
        for each_char in s:
            if each_char not in frequency_map:
                frequency_map[each_char] = 1
            else:
                frequency_map[each_char] += 1
        #Using string concatenation (res += char_) inside a loop is not efficient in Python due to immutability of strings.
# Better: Use a list and join at the end:
        res = []
        for char_ in order:
            if char_ in frequency_map:
                count = frequency_map[char_]
                for i in range(count):
                    res.append(char_)
                del frequency_map[char_]
            
        for key,value in frequency_map.items():
            for i in range(value):
                res.append(key) 
            
        return "".join(res)
                



