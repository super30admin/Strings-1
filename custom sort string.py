class Solution:
    def customSortString(self, order: str, s: str) -> str:

        map={}

        for i in range(len(s)):
            if s[i] not in map:
                map[s[i]]=1
            else:
                map[s[i]]+=1
        word=[]
        for i in range(len(order)):
            if order[i] in map:
                for j in range(map[order[i]]):
                    word.append(order[i])
                del map[order[i]]
        for c in map:
            for i in range(map[c]):
                word.append(c)
        
        return ''.join(word)