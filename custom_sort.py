class Solution:
    def customSortString(self, order: str, str: str) -> str:
        """
        keyIdea: put str elemenets in hashmap and then check if order element in hashmap. if yes, append res with given order
        TC: O(len(str)) + O(1) since given both str and order has length of at max 200 and 26 respectively
        SC: O(26) or O(1)
        """
        hashmap={}
        for s in str:
            if s in hashmap:
                hashmap[s]+=1
            else:
                hashmap[s]=1
        stringbuilder=""
        for ch in order:
            if ch in hashmap:
                for i in range(hashmap[ch]):
                    stringbuilder=stringbuilder+ch
                del hashmap[ch]
        # print(stringbuilder)
        
        for remaining_ele in hashmap:
            freq = hashmap[remaining_ele]
            while freq:
                stringbuilder+=remaining_ele
                freq-=1
        return stringbuilder
                
                
                
                
                
            
        
        