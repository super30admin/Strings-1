class Solution:
    def customSortString(self, order: str, s: str) -> str:
        if(len(order)==0 or len(s)==0):
            return s
        tab = dict()
        for i in s:
            if(tab.get(i) is None):
                tab[i] = 0
            tab[i] +=1
        sb = ""
        for x in range(len(order)):
            ch = order[x]
            count = 0
            if(tab.get(ch) is not None):
                count = tab[ch]
                tab.pop(ch, None)
            while(count>0):
                sb+=ch
                count-=1
        for key in tab.keys():
            count = tab[key]
            while(count>0):
                sb+=key
                count-=1
        return sb
                
        