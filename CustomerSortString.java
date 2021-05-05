//Approach - keep a track of the number of characters repetition in the string T,
// for the chars in the string S and in the same order,
// the chars are added to the result for the total count found in counts array
//Time Complexity - O(T+S) - T - length of T, S - length of S
//Space Complexity - O(26) for counts

class Solution {
  public String customSortString(String S, String T) {

    if(S == null || T == null){
      return T;
    }

    int sLen = S.length();
    int tLen = T.length();

    int[] counts = new int[26];

    for(char ch: T.toCharArray()){
      counts[ch - 'a']++;
    }

    StringBuilder result = new StringBuilder();
    for(char c: S.toCharArray()){

      for(int i=0; i<counts[c-'a']; i++){
        result.append(c);
      }
      counts[c-'a'] = 0;
    }

    for(char c='a'; c<='z'; c++){

      for(int i=0; i<counts[c-'a']; i++){
        result.append(c);
      }
    }

    return result.toString();
  }
}
