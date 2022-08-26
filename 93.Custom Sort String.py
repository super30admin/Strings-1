class Solution:
    def customSortString(self, order: str, s: str) -> str:
        m = {}
        result = []
        # chars = {k: 0 for k in order}
        # print(chars)
        for i in range(len(s)):  # frequency map
            # if s[i] not in m.keys():
            #     m[s[i]] = 1
            # else:
            #     m[s[i]] += 1
            c = s[i]
            m[c] = m.get(c, 0) + 1

        for i in range(len(order)):
            ch = order[i]
            if ch in m.keys():
                count = m.get(ch)
                while count > 0:
                    result.append(ch)
                    count -= 1
                # del m[ch]
                m.pop(ch)

        for i in m.keys():
            count = m.get(i)
            while count > 0:
                result.append(i)
                count -= 1
        return "".join(result)

# Time Complexity  = O(N+M)
# Space complexity : for Dictionary D O(1) and for List L O(n)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : Syntax error
