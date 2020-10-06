//https://leetcode.com/problems/longest-substring-without-repeating-characters/
////Runtime complexity: O(N)
////Space complexity: O(N)
////Insights:

////Algo explanation:
////
//// initialize a hashmap of characters you've seen
//// for each character
////    if you've seen it, start at Math.max of (current S, hashmap() stored value for it)
////    set hashmap(current character) to current End + 1
////    set current max to Math.max(current max and E - S + 1 (current intervanl))
////    increment End
//// return max

///**
// * @param {string} s
// * @return {number}
// */
var lengthOfLongestSubstring;

lengthOfLongestSubstring = function(s) {
  var E, S, ch, hashmap, max;
  if (s === null || s.length === 0) {
    return 0;
  }
  hashmap = new Map();
  S = 0;
  E = 0;
  max = Number.MIN_SAFE_INTEGER;
  while (E < s.length) {
    ch = s[E];
    if (hashmap.has(ch)) {
      S = Math.max(S, hashmap.get(ch));
    }
    hashmap.set(ch, E + 1);
    max = Math.max(max, E - S + 1);
    E += 1;
  }
  return max;
};

lengthOfLongestSubstring('abcabcbb');

//# sourceMappingURL=problem2-longest-substring.js.map
