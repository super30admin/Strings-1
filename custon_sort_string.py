class Solution:
    def customSortString(self, S: str, T: str) -> str:
        if S is None or len(S)==0:
            return T
        char_map={}
        res=[]
        s=""
        for i in range(len(T)):
            if T[i]  in char_map:
                # print(T[i])
                char_map[T[i]]+=1
            else:
                char_map[T[i]]=1
        print(char_map)
        for i in range(len(S)):
            if S[i] in char_map:
                count=char_map[S[i]]
                while(count>0):
                    res.append(S[i])
                    count-=1
                del char_map[S[i]]
        for key in char_map:
            count =char_map[key]
            while count>0:
                res.append(key)
                count-=1
            # count = char_map[T[i]]
            # while(count>0):
            #     res.append(char_map[T[i]])
                # count -=1
        return s.join(res)
            
                    