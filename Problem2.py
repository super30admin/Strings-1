#time complexity o(n)
#space complexity o(1)
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        result = []
        hmap = defaultdict(int)
        n = len(s)
        m = len(order)
        for i in range(n):
            hmap[s[i]] += 1
        
        for j in range(m):
            if order[j] in hmap:
                cnt = hmap[order[j]]
                while cnt > 0:
                    result.append(order[j])
                    cnt -= 1
                del hmap[order[j]]
        
        #keys which are not there in order string
        for key in hmap.keys():
            cnt = hmap[key]
            while cnt > 0:
                result.append(key)
                cnt -= 1

        return "".join(result)
            


        