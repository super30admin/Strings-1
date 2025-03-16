class Solution:
    def customSortString(self, order: str, s: str) -> str:
        if order == None or len(order) == 0:
            return s
        result = []
        map = dict()
        for i in range(len(s)):
            if s[i] not in map:
                map[s[i]] = 1
            else:
                map[s[i]] = map[s[i]] + 1


        for i in range(len(order)):
            if order[i] in map:
                c = order[i]
                times = map[c]

                for j in range(times):
                    result.append(c)
                del map[c]
        for key,value in map.items():
            for i in range(value):
                result.append(key)

        return "".join(result)        


        