class Solution(object):
    def customSortString(self, S, T):
        """
        :type S: str
        :type T: str
        :rtype: str
        """
        hashMap = {}
        output = ""
        
        for ch in T:
            hashMap[ch] = hashMap.get(ch, 0) + 1
        
        for ch in S:
            if ch in hashMap:
                count = hashMap[ch]
                while count > 0:
                    output += ch
                    count -= 1
                del hashMap[ch]
                
        for key, value in hashMap.items():
            while value > 0:
                output += key
                value -= 1
            del hashMap[key]
        
        return output
        
#timeComplexity: o(n)
#spaceComplexity: o(n)
