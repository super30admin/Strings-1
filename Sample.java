// Problem 1 - Custom Sort String
// Time complexity: O(n + 2m) where n = length of S and m = length of T
// Space complexity: O(1)

// Algorithm
// 1 - initialize an array of length 26
// 2 - loop over T String
// 3 - add the frequency of char to array
// 4 - loop over S String
// 5 - if char present in T, then add that many frquency times to output
// 6 - loop over T to add remaining characters to output
class Solution {
  public String customSortString(String S, String T) {
    // 1
    int[] charArr = new int[26];
    String result = "";
    // 2
    for (int i=0; i<T.length(); i++) {
      char ch = T.charAt(i);
      // 3
      charArr[ch - 'a'] += 1;
    }
    // 4
    for (int i=0; i<S.length(); i++) {
      char ch = S.charAt(i);
      // 5
      while (charArr[ch - 'a'] > 0) {
        result += ch;
        charArr[ch - 'a'] -= 1;
      }
    }
    // 6
    for (int i=0; i<T.length(); i++) {
      char ch = T.charAt(i);
      while (charArr[ch - 'a'] > 0) {
        result += ch;
        charArr[ch - 'a'] -= 1;
      }
    }

    return result;
  }
}

// Problem 2 - Longest Substring Without Repeating Characters
// Time complexity: O(n^2) where n = length of string
// Space complexity: O(n)

// Algorithm
// 1 - initiliaze pointers, max and hashset
// 2 - while condition
// 3 - check if char present in hashSet
// 4 - if yes, then start removing char from pointer j
// 5 - else add the char to hashset and store the max length
class Solution {
  public int lengthOfLongestSubstring(String s) {
    if (s == null || s.length() == 0) {
      return 0;
    }
    // 1
    int i = 0;
    int j = 0;
    int max = Integer.MIN_VALUE;
    HashSet<Character> hashSet = new HashSet<>();
    // 2
    while (i < s.length()) {
      char ch = s.charAt(i);
      // 3
      if (hashSet.contains(ch)) {
        // 4
        hashSet.remove(s.charAt(j));
        j++;
      } else { // 5
        hashSet.add(ch);
        max = Math.max(max, hashSet.size());
        i++;
      }
    }

    return max;
  }
}
