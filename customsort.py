import  collections


# TC:- O(n)
# Space:- O(n)
class Solution:
    def customSortString(self, order: str, str: str) -> str:
        if order is None or len(order) == 0: return None
        frequency_map = collections.defaultdict(int)
        result = ''
        for char in str:
            frequency_map[char] += 1
        for char in order:
            if char in frequency_map.keys():
                counter = frequency_map[char]
                while counter > 0:
                    result = result + '' + char
                    counter -= 1
                del frequency_map[char]
        for char in frequency_map.keys():
            counter = frequency_map[char]
            while counter > 0:
                result = result + '' + char
                counter -= 1
        return result


if __name__ == '__main__':

    print(Solution().customSortString(order="cba",str="abcd"))
