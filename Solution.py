'''
// Time Complexity :
# Problem 1 - O(m+n) m - length of order, n - length of string (both can be constant of 26 letters) 
# Problem 2 - O(n), n - is the length of the string
// Space Complexity :
# Problem 1 - O(1) to store in hashmap
# Problem 2 - O(1) constant as there will be limit of characters (26 letters)
// Did this code successfully run on Leetcode :
# Yes the code ran successfully.

// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
'''
## Problem 1 - Custom Sort String
# Hashmap
# Parse over the string 's' and add the character to the hashmap along with its frequency
# Parse over the order and append the characters in sequence from the hashmap by reducing the frequency
# of characters in the order. When the frequency becomes '0' we remove it from the map.
# Parse over the remaining elements of the map and append them. The order of these characters doesn't 
# matter.
# Return the result array.

class Solution(object):
    def customSortString(self, order, s):
        """
        :type order: str
        :type s: str
        :rtype: str
        """
        if order == None or len(order) == 0 or s == None or len(s) == 0:
            return s
        sb = []
        map1 = {}
        m = len(order)
        n = len(s)

        for i in range(n):
            ch = s[i]
            if ch in map1:
                map1[ch] += 1
            else:
                map1[ch] = 1
        
        result = []
        for i in range(m):
            ch = order[i]
            if ch in map1:
                while map1[ch] > 0:
                    result.append(ch)
                    map1[ch] -= 1
                del map1[ch]

        for char in map1:
            while map1[char] > 0:
                result.append(char)
                map1[char] -= 1
        return ''.join(result)


## Problem 2 - Longest Substring Without Repeating Characters
# Two Pointers
# Iterate the fast pointer until it is less than the length of the string.
# When a repeated character is found, remove all elements from the hashset and move the slow pointer 
# to escape the repeated character
# If the character is unique we continue adding in the hashset and increment the fast pointer
# Get the max length of the string by comparing the exisiting max length and the difference between the
# pointers. Return the maximum length of the string.

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        if s == None or len(s) == 0:
            return 0
        set_1 = set()
        max_length = 0
        slow = 0
        fast = 0
        n = len(s)
        while fast < len(s):
            c = s[fast]
            while c in set_1:
                ## move the slow pointer to escape the repeated character
                set_1.remove(s[slow])
                slow += 1
            set_1.add(c)
            max_length = max(max_length, fast - slow + 1)
            fast += 1
        return max_length

# Hashmap
# Edge case when the string is empty we return 0/
# For loop over characters of the string, store the character in the hash map with frequency
# If the character already exists then we update the frequency
# Find the max length of characters by taking existing length and difference current character index
# with slow pointer and return the maximum length.  

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        if s == None or len(s) == 0:
            return 0
        set_1 = {}
        max_length = 0
        slow = 0
        n = len(s)
        for i in range(n):
            c = s[i]
            if c in set_1:
                slow = max(slow, set_1[c]+1)
            set_1[c] = i
            max_length = max(max_length, i - slow + 1)
        return max_length
