//https://leetcode.com/problems/custom-sort-string/
//Runtime complexity:
//Space complexity:
//Problems:

// Algo explanation:

// Store T characters into a hashmap by key:pair character:number_occurrences
// for each character in S
//    write number of characters (if any) from T
//    (remove this character from hashmap)

// write out any characters left from T

///**
// * @param {string} S
// * @param {string} T
// * @return {string}
// */
var customSortString;

customSortString = function(S, T) {
  var hashmap, i, j, m, n, o, output, ref, ref1, ref2;
  if (S === null || S.length < 1) {
    return T;
  }
  if (T === null || T.length < 1) {
    return null;
  }
  hashmap = new Map();
  for (i = m = 0, ref = T.length; (0 <= ref ? m < ref : m > ref); i = 0 <= ref ? ++m : --m) {
    hashmap.set(T[i], (hashmap.get(T[i]) || 0) + 1);
  }
  output = [];
  for (i = n = 0, ref1 = S.length; (0 <= ref1 ? n < ref1 : n > ref1); i = 0 <= ref1 ? ++n : --n) {
    if (hashmap.has(S[i])) {
      for (j = o = 0, ref2 = hashmap.get(S[i]); (0 <= ref2 ? o < ref2 : o > ref2); j = 0 <= ref2 ? ++o : --o) {
        output.push(S[i]);
      }
      hashmap.delete(S[i]);
    }
  }
  hashmap.forEach(function(v, k) {
    var l, p, ref3, results;
    results = [];
    for (l = p = 0, ref3 = v; (0 <= ref3 ? p < ref3 : p > ref3); l = 0 <= ref3 ? ++p : --p) {
      results.push(output.push(k));
    }
    return results;
  });
  return output.join('');
};

console.log(customSortString("cba", "abcd")); // expect 'cbad'

console.log(customSortString("kqep", "pekeq")); // expect 'kqeep'

//# sourceMappingURL=problem1-custom-sort-string.js.map
