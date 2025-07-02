class Solution:
    def customSortString(self, order: str, s: str) -> str:
        """
        TC: O(n+m); n: len of string s, and m : length of order (which is 26); so O(n *26) = O(n)
        AS: O(1)
        """
        hashMap = {}
        substring = ""

        for i in range(len(s)):
            if s[i] not in hashMap:
                hashMap[s[i]] = 1
            else:
                hashMap[s[i]] += 1

        for i in range(len(order)):
            if order[i] in hashMap:
                substring += hashMap[order[i]] * order[i]
                del hashMap[order[i]]

        for k,v in hashMap.items():
            substring += v*k

        return substring