cclass Solution:

    def customSortString(self, S: str, T: str) -> str:

       
        T_map = dict()

        for i in T: # O(n) complexity

            if i not in T_map:

                T_map[i] = 0

            T_map[i] += 1

        res = ""

        for i in S: # O(m) complexity

            count = T_map.get(i, 0) # Instead we can use if i in T_map then only proceed inside

            res += i * count

            T_map.pop(i, None)

        for key, value in T_map.items():

            res += key * value

        return res

#TC : O(m+n)
#SC : O(m+n)