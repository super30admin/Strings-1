class Solution:
    
    """
    Description: permute the characters of T so that they match the order that S was sorted from two strings S and T
    
    Time Complexicity: O(length(T)) or O(length(S)) whichever is larger
    Space Complexicity: O(length(T))
    
    Approach:
    - Create a hashmap with count of occurance of every letter in string T
    - Iterate through S and append letters in same order for each count, drop the key from hashmap
    - Iterate a fixed for loop with remaining keys in the hash table and use similar to above to add elements
    - combine all using "".join
    """
    
    def customSortString(self, S: str, T: str) -> str:
        
        if T == None or len(T) == 0: return ""
        
        str_dict = {}
        for i, c in enumerate(T):
            if c in str_dict: str_dict[c] += 1
            else: str_dict[c] = 1
            
        result = []
        for c in S:
            if c in str_dict:
                count = str_dict[c]
                while count > 0:
                    result.append(c)
                    count -= 1
                str_dict.pop(c)
                    
        for c in str_dict.keys():
            count = str_dict[c]
            while count > 0:
                result.append(c)
                count -= 1
        
        return "".join(result)
