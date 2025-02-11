class Solution:
    def customSortString(self, order: str, s: str) -> str:
        if s == None or s =='':
            return ''
        hashset = dict()
        result = ''
        for i in range(len(s)):
            if s[i] not in hashset:
                hashset[s[i]] = 1
            else:
                hashset[s[i]] = hashset[s[i]] + 1
       #print(hashset)
        for j in range(len(order)):
            if order[j] in hashset:
                for k in range(hashset[order[j]]):
                    result = result + order[j]
                hashset.pop(order[j])
        for key in hashset:
            for p in range(hashset[key]):
                result = result + key

        return result

        