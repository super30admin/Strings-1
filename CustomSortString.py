# -*- coding: utf-8 -*-
"""
Algorithm - 

Step 1: Initialize t_dict for storing letter in T as key and count of number of times, it is occuring in T as value
        and result for storing the final string formed
Step 2: Iterate through string T using for loop and store each letter in t_dict as key and number of times it is 
        occuring as value
Step 3: Iterate through each letter in S, if it is present in t_dict, add that particular letter to result the number of itmes
        the value of that particular dict i.e. key should be added value number of times. 
        After adding it to the result, del
Step 4: Return the reesult

Time Complexity - O(N+M) where N = len(S) and M = len(T)
Space Complexity - O(N) because of dictionary (t_dict)

Code accepted in leetcode

"""

class Solution:
    def customSortString(self, S: str, T: str) -> str:
        
        t_dict = {}
        result = '' 
        
        # Iterate through T and create a dictionary
        for letter in T:
            if letter in t_dict:
                t_dict[letter] = t_dict[letter]+1
            else:
                t_dict[letter]=1
        # Iterate through S and if they are present in dictionary t_dict created above, add it to the result string
        for letter in S:
            if letter in t_dict:
                result = result + letter * t_dict[letter] # if a is occuring for e.g twice then letter will be t and multiplying it with 2 will add aa
                # Deleting the particular letter from the string so that we get the remaining letter to be added in result
                del t_dict[letter]
        # Adding the remaining letters to the result which are present in T but not in S    
        for letter in t_dict:
            result = result + letter * t_dict[letter]
                
        return(result)
        
        
        
        