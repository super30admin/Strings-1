/**
 * @param {string} order
 * @param {string} s
 * @return {string}
Intuition:
  First, build a frequency map so you know how many times each character appears in `s`.
  Then, go through `order` and place those characters into the result first, repeating each one based on its frequency.
  Finally, add any remaining characters from `s` that weren’t mentioned in `order`, in any order.
  T.C: O(n+m)
  S.C: O(1)
 */
var customSortString = function (order, s) {
    const charCountMap = new Map();
    // build the charCountMap
    for (let char of s) {
        let count = ((charCountMap.get(char) ?? 0) + 1);
        charCountMap.set(char, count);
    }
    let res = '';
    // iterate over order now
    for (let char of order) {
        if (charCountMap.has(char)) {
            const charFreq = charCountMap.get(char);
            for (let i = 0; i < charFreq; i++) {
                res += char;
            }
        }
        charCountMap.delete(char);
    }

    for (let [char, freq] of charCountMap) {
        for (let i = 0; i < freq; i++) {
            res += char;
        }
    }
    return res;
};