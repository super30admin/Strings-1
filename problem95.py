class Solution:
    def customSortString(self, order: str, s: str) -> str:
        if not order and not s:
            return ""

        hashMap = {}

        result = []

        for i in range(len(s)): #get count of all chars in s
            ch = s[i]
            hashMap[ch] = hashMap.get(ch, 0)+1

        for i in range(len(order)): #get each char in order and append to result
            ch = order[i]

            while hashMap.get(ch, 0) != 0: #if ch is in order but not in s raises error
                result.append(ch)
                hashMap[ch] -= 1

        for key in hashMap.keys():#append remaining elements
            while hashMap[key] != 0:
                result.append(key)
                hashMap[key] -= 1

        return "".join(result)        

# Time Complexity: O(M+N) = O(N) because max is O(26+26)
# Space Complexity: O(1) (excluding the output string, since the hashmap is bounded by a fixed alphabet size)