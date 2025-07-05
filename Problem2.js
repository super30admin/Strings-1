// ## Problem2 

// Longest Substring Without Repeating Characters(https://leetcode.com/problems/longest-substring-without-repeating-characters/)

//TC : O(n)
//SC : O(1)
var lengthOfLongestSubstring = function(s) {
    let maxNo = -Infinity;
    s = s.split('');
    let hashMap = new Map();
    let i = 0;

    for (let j = 0; j < s.length; j++) {
        if (hashMap.has(s[j])) {
            // move i to one after the last seen position of the duplicate
            i = hashMap.get(s[j]) + 1;
        }
        hashMap.set(s[j], j); // update with latest index
        maxNo = Math.max(maxNo, j - i + 1);
    }

    return maxNo === -Infinity ? 0 : maxNo;
};
