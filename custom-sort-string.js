// Time Complexity : O(M + N) where M and N are the lengths of S and T
// Space Complexity : O(T)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * @param {string} S
 * @param {string} T
 * @return {string}
 */
var customSortString = function(S, T) {
    if (!S || !S.length) return T;
    if (!T || !T.length) return '';
    
    let letterCount = new Array(26).fill(0);
    
    for (const [index, char] of [...T].entries()) {
        letterCount[T.charCodeAt(index) - 97]++;
    }
    let answer = '';
    
    for (const [index, char] of [...S].entries()) {
        let charCode = S.charCodeAt(index) - 97;
        for (let i = 0; i < letterCount[charCode]; i++) {
            answer += char;
        }
        letterCount[S.charCodeAt(index) - 97] = 0;
    }
    for (let i = 0; i <= 26; i++) {
        let currLetter = String.fromCharCode(i + 97);
        for (let j = 0; j < letterCount[i]; j++) {
            answer += currLetter;
        }
    }
    
    return answer;
};
