class Solution(object):
    def customSortString(self, order, s):
        """
        :type order: str
        :type s: str
        :rtype: str
        """

        char_count = {}

        for char in s:
            char_count[char] = char_count.get(char,0) +1
        
        result = []

        for char in order:
            if char in char_count:
                result.append(char*char_count[char])
                del char_count[char]
        
        for char, count in char_count.items():
            result.append(char * count)
        
        return ''.join(result)

        #time: n + m n is the length of s and m is the length of the oder
        #space: k, k is the size of the character set 
