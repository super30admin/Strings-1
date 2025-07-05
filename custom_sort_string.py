# Approach:
# ----------
# 1. Count the frequency of each character in `s` using a Counter.
# 2. Iterate over `order`:
#    - For each character, if it exists in `s`, append it multiplied by its count.
#    - Remove it from the counter to avoid duplication later.
# 3. Append the remaining characters from the counter (those not in `order`).
# 4. Join and return the final list as a string.

# Time Complexity: O(n + m), where n = len(s), m = len(order), but there will be only unique 
# small alphabets therefore m = 26 constant Hence, Time Complexity: O(n + 26) = O(n)
# Space Complexity: O(k), for the frequency Map same as above there will be only unique keys
# Hence, Space Complexity for map is O(1)
# we are using result list and output required is string hence the space for result array
# is length of result string - k

class Solution:
    def CustomSortString(self, order, s):
        Count_s = Counter(s)
        res = []
        for ch in order:
            if ch in Count_s:
                res.append(ch * Count_s[ch])
                del Count_s[ch]
        for k, v in Count_s.items():
            res.append(k * v)
        return ''.join(res)

# Main function to test the solution
def main():
    sol = Solution()

    print("Test Case 1:")
    print("Result:", sol.CustomSortString("cba", "abcd"))  # Expected: "cbad"

    print("\nTest Case 2:")
    print("Result:", sol.CustomSortString("bcafg", "abcd"))  # Expected: "bcad" or similar

    print("\nTest Case 3:")
    print("Result:", sol.CustomSortString("", "xyz"))  # Expected: "xyz" (order doesn't matter)

    print("\nTest Case 4:")
    print("Result:", sol.CustomSortString("xyz", ""))  # Expected: "" (empty input)

    print("\nTest Case 5:")
    print("Result:", sol.CustomSortString("zyxwv", "vwxyz"))  # Expected: "zyxwv"

if __name__ == "__main__":
    main()
