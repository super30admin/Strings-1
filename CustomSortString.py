class Solution:
   def customSortString(self, order: str, s: str) -> str:
    dic = {}
    for char in s:
        dic[char] = dic.get(char, 0) + 1  
    
    result = []
    
    for i in order:  
        if i in dic:
            result.append(i * dic[i])  
            del dic[i]  

    for j, k in dic.items():  
        result.append(j * k)

    return "".join(result)  