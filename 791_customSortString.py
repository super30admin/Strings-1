class Solution:
    def customSortString(self, order: str, s: str) -> str:
        if order==None or s==None: return s 
        orderMap ={}; revMap ={}
        
        i = 0
        for char in order:
            orderMap[char] = i
            revMap[i] = char
            i+=1
            
        numlist =[]
        charList=[]
        for char in s:
            if char in orderMap:
                numlist.append(orderMap[char])
            else:
                charList.append(char)
                
        numlist.sort()
        for i in range(len(numlist)):
            numlist[i] = revMap[numlist[i]]
        numlist.extend(charList)
        
        return "".join(numlist)