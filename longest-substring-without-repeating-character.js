// Time Complexity : O(N)
// Space Complexity : O(1) (max 26 letters in the set)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * @param {string} s
 * @return {number}
 */

var lengthOfLongestSubstring = function(s) {
    let left = 0, right = 0, result = 0,
    stringSet = new Set();
    while (right < s.length) {
        if (stringSet.has(s[right])) {
            stringSet.delete(s[left++]);
        } else {
            stringSet.add(s[right++]);
            result = Math.max(result, stringSet.size);
        }
    }
    return result;
};
