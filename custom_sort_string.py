class Solution:
    def customSortString(self, order: str, s: str) -> str:

        ## T.C = O(n)
        ## S.C = O(1)

        hm = collections.Counter(s)
        tmp_str = ''

        for i in order:
            if i in hm.keys():
                tmp_str += i*hm[i]
                del hm[i]
        
        keys = list(hm.keys())
        for i in keys:
            tmp_str += i*hm[i]
            del hm[i]
        
        return tmp_str