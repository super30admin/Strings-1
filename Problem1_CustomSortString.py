'''
====== Submission Details =======
Student Name: Pavan Kumar K. N.
S30 SlackID : RN32MAY2021
=================================
'''

# 791. Custom Sort String

# order and str are strings composed of lowercase letters. In order, no letter occurs more than once.

# order was sorted in some custom order previously. We want to permute the characters of str so that 
# they match the order that order was sorted. 
# More specifically, if x occurs before y in order, then x should occur before y in the 
# returned string.

# Return any permutation of str (as a string) that satisfies this property.




#-----------------
# Time Complexity: 
#-----------------
# O(len(string) + len(order)) - Need to process every characters in input string "string" and "order"
#------------------
# Space Complexity: 
#------------------
# O(len(string)): Max size of hashmap = 26 characters and their index - constant O(1)

#-----------------------
# Leet Code Performance: 
#-----------------------
# Ran Successfully?: Yes


class Solution(object):
    def customSortString(self, order, string):
        """
        :type order: str
        :type string: str
        :rtype: str
        """
        if len(string) == 0:
            return ""
        
        hashmap = {}
        str_list = []
        
        for i in range(len(string)):
            c = string[i]
            if c in hashmap:
                hashmap[c] += 1
            else:
                hashmap[c] = 1
        
        for i in range(len(order)):
            c = order[i]
            if c in hashmap:
                count = hashmap[c]
                while count > 0:
                    str_list.append(c)
                    count -= 1
                del hashmap[c]
        
        for char in hashmap.keys():
            count = hashmap[char]
            while count > 0:
                str_list.append(char)
                count -= 1
            del hashmap[char]
        
        return "".join(str_list)