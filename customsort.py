class Solution:
    
    """
    Description: permute the characters of T so that they match the order that S was sorted from two strings S and T
    
    Time Complexicity: O(length(T)) or O(length(S)) whichever is larger
    Space Complexicity: O(length(T))
    
    Approach:
    - Create a hashmap with count of occurance of every letter in string T
    - Iterate through S and append letters in same order for each count
    - Iterate a fixed for loop with 26 small letters to check if the element is present in hashmap
      + add elements in resulting list successively
    """
    
    def customSortString(self, S: str, T: str) -> str:
        
        if T == None or len(T) == 0: return ""
        
        str_dict = {}
        for i, c in enumerate(T):
            if c in str_dict: str_dict[c] += 1
            else: str_dict[c] = 1
            
        result = []
        for i, c in enumerate(S):
            if c in str_dict:
                count = str_dict[c]
                while count > 0:
                    result.append(c)
                    count -= 1
                    
        for i in range(97, 123):
            c = chr(i)
            if c in str_dict and not c in result:
                count = str_dict[c]
                while count > 0:
                    result.append(c)
                    count -= 1
        
        return "".join(result)
