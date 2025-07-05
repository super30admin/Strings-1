# Time complexity: O(n + m)
# Space complexity: O(n)

def customSortString(order, s):
    count = {}
    for char in s:
        if char in count:
            count[char] += 1
        else:
            count[char] = 1
    result = ""

    for char in order:
        if char in count:
            result += char * count[char]
            del count[char]

    for char, freq in count.items():
        result += char * freq

    return result
