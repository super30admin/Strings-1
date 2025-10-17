"""
TC: O(L_order plus L_s) The time complexity is dominated by counting characters in 's' (O(L_s)) and iterating over 'order' and the remaining map items. The total time is linear with respect to the total length of both strings.
SC: O(1) The space complexity is constant because the hash map (Counter) will hold at most 26 entries.

Approach:

This problem is solved using a Hash Map (Counter) to track the frequency of characters in string s and then building the result based on the custom order.

1. Count Frequencies: We use a Counter to store the occurrence count of every character in s.
2. Apply Custom Order: We iterate through the order string. For each character, we append it to the result string, repeated by its count, and then delete it from the Counter. This ensures characters that are in order are placed in the correct relative sequence.
3. Append Remaining Characters: Finally, we iterate through any characters left in the Counter (those not in order) and append them to the result string, repeated by their count.

The problem ran successfully on LeetCode.
"""
class Solution:
    def customSortString(self, order: str, s: str) -> str:
        counter = Counter(s)
        res = ""

        for i in range(len(order)):
            ch = order[i]
            if ch in counter:
                res += (ch)*counter[ch]
                del counter[ch]

        for k,v in counter.items():
            res += (k)*v
        
        return res