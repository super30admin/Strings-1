# time complexity : 0(N) : N length of string S
class Solution(object):
    def customSortString(self, order, str):
        
        mymap = {}
        
        for ch in str:
            if ch not in mymap:
                mymap[ch] = 1
            else:
                mymap[ch]+= 1
        
        result = ""
        for ch in order :
            if ch in mymap:
                result+=ch*mymap[ch]
                del mymap[ch]
        
        keys = mymap.keys()
        
        if len(keys)!= 0:
            for key in keys:
                result+= key * mymap[key]
                del key
                
        return result
        """
        :type order: str
        :type str: str
        :rtype: str
        """
        