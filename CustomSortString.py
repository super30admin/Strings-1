class Solution:
    def customSortString(self, S: str, T: str) -> str:
        my_map = {}
        my_str =""
        another_str = ""
        for i in range(len(T)):
            if T[i] not in my_map:
                my_map[T[i]]= 1
            else:
                my_map[T[i]]+=1
                
        print(my_map)
        
        for i in range(len(S)):
            count = my_map.get(S[i],0) #That's how we set default values in Python
            for j in range(count):
                my_str += S[i]
                my_map[S[i]] -= 1
        for i in range(len(T)):
            count = my_map.get(T[i])
            if count >0:
                my_str += T[i]
        return my_str
            
                