#Time complexity:O(N+k) but k is at max 256 hence O(N)
#Space complexity:O(k) but k is at max 256 so O(1)
class Solution:
    def customSortString(self, order, s) :

        if s == None or len(s) == 0 or order == None or len(order) == 0:
            return s

        hashmap = {}
        result = []
        n1 = len(s)
        n2 = len(order)

        for ch in s:

            if ch not in hashmap:
                hashmap[ch] = 0

            hashmap[ch] += 1

        for ch in order:

            if ch in hashmap:
                count = hashmap[ch]
                while count > 0:
                    result += ch
                    count -= 1
                del hashmap[ch]
        for key, val in hashmap.items():
            while val:
                result += key
                val -= 1
        return "".join(result)
