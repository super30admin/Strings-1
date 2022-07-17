#Time complexity : O(m+n) where n is length of order and m is the length of string 
#Space complexity : O(1) as the maximum character in hashmap will be 26 so space is constant
#Did this code successfully run on Leetcode : Yes
#youtube : https://youtu.be/ZOPk3E8t_CA
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        #null condition
        if s=="" and len(s)==0:
            return ""
        #create the hashmap for storing the characters and value as the number of times characters repeated in the string s
        hashmap = {}
        #putting the values in the hashmap 
        for i in s:
            if i in hashmap:
                hashmap[i] = hashmap.get(i,0) +1
            else:
                hashmap[i] = 1
        result =""
        #putting the characters in the result string 
        for character in order:
            if character in hashmap:
                #we are mainting the count to keep track that the occurances of the characters
                count = 0
                while count < hashmap.get(character):
                    result += character
                    count += 1
                #remove the element of hashmap once the count is equal to the number of alphabets belong to the element in hashmap
                del hashmap[character]

        #putting the remaining elements of the hashmap in the result
        for character in hashmap:
            count =0
            while count < hashmap.get(character):
                result += character
                count += 1
        return result
