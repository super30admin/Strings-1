# time complexity:O(m+n)-m is len(order), n is len(s)
# Space complexity: O(1)-hashmap can have max 26 keys
# Approach: first put the letters in string s into a hashmap
# then traverse the order string and check if its in hashmap.
# if in hashmap, get the value of the character from hashmap and that would be the count.
# append the letter for count number of times into result and remove the character from hashmap after adding.
# now add the remaining keys in hashmap after traversing order.


class Solution:
    def customSortString(self, order: str, s: str) -> str:
        map = dict()
        for char in s:
            if char in map:
                map[char]= map[char]+1
            else:
                map[char] = 1
        result = str()
        for letter in order:
             if letter in map:
                count = map[letter]
                while count > 0:
                    result += letter
                    count = count - 1
                map.pop(letter)
        for key in map:
            count = map[key]
            while count > 0:
                result += key
                count = count - 1
            #map.pop(key)
        return result 
            
            
        