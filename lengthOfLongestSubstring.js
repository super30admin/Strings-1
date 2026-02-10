/**
 * @param {string} s
 * @return {number}

 Intuition:
 Use a sliding window (left to right) to track a substring with all unique characters.
 If the next character is already in the window, shrink from the left until it’s unique.
 At each step, the size of the set gives the length of the current substring, and we track the maximum.
 T.C: O(n)
 S.C: O(1)
 */
var lengthOfLongestSubstring = function (s) {
    let set = new Set();
    let left = 0;
    let maxLength = 0;
    for (let right = 0; right < s.length; right++) {
        while (set.has(s[right])) {
            set.delete(s[left]);
            left++;
        }
        set.add(s[right]);
        maxLength = Math.max(set.size, maxLength);
    }
    return maxLength;
};