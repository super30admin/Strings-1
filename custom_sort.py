# Time Complexity: O(m + n)
# Space COmplexity: O(n)
from collections import defaultdict


class Solution:
    result = ""

    #     We will add all the lements to its count in hmap for given string
    #   the we will iterate over the order string and if that element is present in the hmap we will add it to the result with occurence as number of counts of that element in hashmap
    # and after that we will just add the remaining elements in the hmap with the respective occurences
    def customSortString(self, order, str):
        self.result = ""

        hmap = defaultdict()

        for i in range(len(str)):
            if str[i] in hmap:
                hmap[str[i]] += 1
            else:
                hmap[str[i]] = 1

        print(hmap)

        for i in range(len(order)):
            curr = order[i]
            if curr in hmap:
                count = hmap[curr]
                while count > 0:
                    self.result += order[i]
                    count -= 1
                hmap.pop(curr)

        for i in hmap.keys():
            count = hmap[i]
            while count > 0:
                self.result += i
                count -= 1

        return self.result
