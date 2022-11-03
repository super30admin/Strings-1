// Custom Sort String (https://leetcode.com/problems/custom-sort-string/)

// Time Complexity : O(n+m) n is the length of string m is the length of order
// Space Complexity : O(n)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * @param {string} order
 * @param {string} s
 * @return {string}
 */
var customSortString = function (order, s) {
    if (order === null || s === null || order.length === 0)
        return s;

    // Maintains char and its frequency in s
    let map = new Map();
    for (let i = 0; i < s.length; i++) {
        let ch = s[i];
        if (!map.has(ch)) {
            map.set(ch, 0);
        }
        map.set(ch, map.get(ch) + 1)
    }
    let ans = "";
    for (let i = 0; i < order.length; i++) {
        // Iterate through order and add the freq times ch from map to ans
        let ch = order[i];
        if (map.has(ch)) {
            let frequency = map.get(ch);
            for (let i = 0; i < frequency; i++) {
                ans += ch;
            }
            map.set(ch, 0);
        }
    }

    map.forEach((value, key) => {
        for (let i = 0; i < value; i++) {
            ans += key;
        }
    });
    return ans;
};