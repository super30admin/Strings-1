# Space Complexity: O(n)
# Time Complexity: O(n)
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        res = []
        mp = collections.defaultdict(lambda : 0)

        for ch in s: 
            mp[ch]+=1

        for i in range(len(order)): 
            ch = order[i]
            if ch in mp: 
                cnt = mp[ch]
                for _ in range(cnt): 
                    res.append(ch)
                del mp[ch]
        
        for k, v in mp.items():
            for i in range(v):
                res.append(k)
        return ''.join(res)

        



