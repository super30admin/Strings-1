class Solution:
    def customSortString(self, order: str, str: str) -> str:
        """using hashmap
        Time complexity-O(n) as we iterate over whole string and order can have just  26 chars, so ignore that
        Space complexity-O(1)"""
        hashmap={}
        li=[]
        for i in range(len(str)):
            if str[i] not in hashmap:
                hashmap[str[i]]=1
            else:
                hashmap[str[i]]+=1
        for i in range(len(order)):
            if order[i] in hashmap:
                count=hashmap[order[i]]
                for j in range(count):
                    li.append(order[i])
                hashmap.pop(order[i])
        for i in hashmap.keys():
            count=hashmap[i]
            for j in range(count):
                li.append(i)        
        return "".join(li)
                    
            
        