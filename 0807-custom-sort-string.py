# We will create frequency map of the string s. We will loop through order and will append required characters to result. We have count in frequency map so that we can club these characters according to frequency.
# For example if order is cba, then we put n number of c, then all b, then all a toegether.
# At the end we append characters which are not in order but in source.
# TC - O(n)
# SC - O(26) = O(1)


class Solution:
    def customSortString(self, order: str, s: str) -> str:
        counter = Counter()
        res = []
        for i in s:
            counter[i]+=1
        for i in order:
            if i in counter:
                count = counter[i]
                for j in range(count):
                    res.append(i)
            del counter[i]
        print(counter)
        for i in counter:
            count = counter[i]
            for j in range(count):
                res.append(i)
        result = ''.join(map(str, res))
        return result

