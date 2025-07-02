#TC O(N^2)
#SC: O(1) #Because 26 alphabets
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        order_dict = {}
        for index, o in enumerate(order):
            order_dict[o] = index
        output  = list(s)
        for i in range(0, len(s)-1):
            for j in range(i+1, len(s)):
                if output[i] in order_dict and output[j] in order_dict:
                    if order_dict[output[i]]>order_dict[output[j]]:
                        temp = output[i]
                        output[i] = output[j]
                        output[j] = temp
        
        return "".join(output)


#TC O(N)
#SC: O(1) because 26 alphabets
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        freq_map = {}
        result = []
        for index,i in enumerate(s):
            if i in freq_map:
                freq_map[i] +=1
            else:
                freq_map[i] = 1
        
        for o in order:
            if o in freq_map:
                result = result + [o]*freq_map[o]
        
        for i in s:
            if i not in order:
                result = result+[i]
        
        return "".join(result)