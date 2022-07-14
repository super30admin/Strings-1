class Solution:
    def customSortString(self, order: str, s: str) -> str:
        # Hashmap - TC  = O(len(s) + len(order)) = O(n+m)
        count = collections.Counter(s)
        result = []

        for c in order:
            result.append(c * count[c])
            count[c] = 0

        for remaining in count:
            result.append(remaining * count[remaining])

        return "".join(result)


'''


        hashmap_order = {"remain":[]}

        for c in s:
            if c in order:
                if c in hashmap_order:
                    hashmap_order[c] += 1
                else:
                    hashmap_order[c] = 1
            else:
                hashmap_order["remain"].append(c)

        result = ""
        for c in order:
            if c in hashmap_order:
                result = result + c*hashmap_order[c]

        result = "".join(hashmap_order["remain"]) + result 
        return result
'''
