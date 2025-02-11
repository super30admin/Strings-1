# ---------------Time O(m), m = len(s), Space = O(26) =O(1)------------------------------------------
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        freq_dict = defaultdict(int)
        result = []
        for char in s: # First count frequeny of all char in s
            freq_dict[char] += 1
        
        # Now iterate on order str and as per the order check if that char is present in freq_dict append it in result as many number of times it is present in the freq_dict
        for c in order:
            if c in freq_dict:
                for i in range(freq_dict[c]):
                    result.append(c)
                del freq_dict[c]       # Delete the key from the freq_dict that is already appended in result
        
        # Add the remining keys/char in the dict as many counts as present in the dict in the result
        for remain_key in freq_dict:  
            for i in range(freq_dict[remain_key]):
                result.append(remain_key)
        
        return "".join(result) # just to convert list to str
        