# TC: O(N) ==> O(S + O) where S is the length of the input string and O is the length of the order string. 
# SC: O(S) since we will be storing all characters of input string in the hashmap. 

class Solution:
    def customSortString(self, order: str, str: str) -> str:
        hmap = {}
        if not order or len(order) == 0: 
            return str
        
        ord_list = list(order)
        str_list = list(str)
        
        for i in range(len(str_list)): 
            hmap[str_list[i]] = hmap.get(str_list[i], 0) + 1
        
        final_str = ''
        for i in range(len(ord_list)): 
            count = hmap.get(ord_list[i])
            while count:
                final_str += ord_list[i]
                count -= 1
                if count == 0: 
                    hmap.pop(ord_list[i])
        
        if len(hmap) > 0: 
            for k,v in hmap.items(): 
                while v: 
                    final_str += k
                    v -= 1
        
        return final_str
