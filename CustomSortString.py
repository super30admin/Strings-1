"""
Rasika Sasturkar
Time Complexity: O(n), n is the length of given string
Space Complexity: O(1)
"""


def customSortString(order: str, s: str) -> str:
    """
    We create the freq. map of the all characters in given string. Then, we
    iterate on the order string, get the count of these characters from the map
    and append it to a new string. Lastly, iterate over the map to append
    remaining characters to the result string.
    """
    char_map = {}

    # creating freq map
    for char in s:
        if char not in char_map:
            char_map[char] = 1
        else:
            char_map[char] += 1

    result = ""

    # adding characters from the order string
    for char in order:
        if char in char_map:
            count = char_map[char]
            for k in range(count):
                result += char
            char_map.pop(char)

    # adding remaining characters
    for key in char_map:
        count = char_map[key]
        for k in range(count):
            result += key

    return result


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    print(customSortString(order="cba", s="abcd"))  # returns cbad
    print(customSortString(order="cbafg", s="abcd"))  # returns cbad


if __name__ == "__main__":
    main()
