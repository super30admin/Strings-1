"""
Brute Force: find all the permutations and check if they follow order or not
TC: n! * n

Optimal way: Create permutation from the order.
TC: O(n) to create hmap + O(n) to traverse the order string  + O(m) to traverse the string c, O(m+n)
SC: O(n), n number of ch in s, which can be considered as O(1) + O(n) list that save the permutation
"""


#Note: this method will not work if the string have duplicate charcaters
class Solution_genetrate_permutation:
    def generate_perm(self, i, s, prem_set, permutation):
        # base case
        if len(s) == len(permutation):
            self.ans.append("".join(permutation))
            return

            # recursion
        for i in range(0, len(s)):
            if s[i] not in prem_set:
                prem_set.add(s[i])
                permutation.append(s[i])
                self.generate_perm(i + 1, s, prem_set, permutation)
                permutation.pop()
                prem_set.remove(s[i])

    def customSortString(self, order: str, s: str) -> str:
        self.ans = []
        permutation = []
        prem_set = set()
        self.generate_perm(0, s, prem_set, permutation)

        # store the order in hmap
        hmap = {}
        for idx, c in enumerate(order):
            hmap[c] = idx

        for per in self.ans:
            prev = -1

            flag = True
            for ch in per:
                if ch in hmap:
                    temp = hmap[ch]
                    if prev > temp:

                        flag = False
                        break
                    else:
                        prev = temp
            if flag:
                return per

        return None

class Solution_hmap_method1:
    def customSortString(self, order: str, s: str) -> str:
        hmap = {}
        # create a frequency map of the s
        for c in s:
            if c not in hmap:
                hmap[c] = 0

            hmap[c] += 1

        ans = []
        # traverse the order string
        for c in order:
            if c in hmap:
                freq = hmap[c]
                for _ in range(freq):
                    ans.append(c)

        # print(hmap)
        # print(ans)
        # traverse the s
        for c in s:
            if c not in order:
                ans.append(c)

        return "".join(ans)



class Solution_method_2:
    def customSortString(self, order: str, s: str) -> str:
        hmap = {}
        # create a frequency map of the s
        for c in s:
            if c not in hmap:
                hmap[c] = 0
            hmap[c] += 1

        ans = []
        # traverse the order string
        for c in order:
            if c in hmap:
                freq = hmap[c]
                for _ in range(freq):
                    ans.append(c)
                del hmap[c]

        if hmap:
            for k, v in hmap.items():
                for _ in range(v):
                    ans.append(k)

        return "".join(ans)





