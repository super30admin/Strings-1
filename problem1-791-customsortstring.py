class Solution:
    def customSortString(self, order: str, s: str) -> str:
        item_freq = {}
        for i in range(len(s)):
            if s[i] in item_freq:
               item_freq[s[i]]+=1
            else:
               item_freq[s[i]]=1

        result = []
        for i in range(len(order)):
            if order[i] in item_freq:
                for j in range(item_freq[order[i]]):
                   result.append(order[i])
                del item_freq[order[i]]

        for item,value in item_freq.items():
            for j in range(value):
                result.append(item)

        return "".join(result)