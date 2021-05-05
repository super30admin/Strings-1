//Approach - Sliding Window - we maintain a map to keep record of
// the char(key) and the latest index of the char(value).
// This char's index will be updated when the same char repeats in the word

//Time Complexity - O(N) - N is length of S
//Space Complexity - O(min(N,M)) - N is length of S and M is 26 (alphabets)

class Solution {
  public int lengthOfLongestSubstring(String s) {

    int result = 0;
    Map<Character, Integer> map = new HashMap<>();

    int start = 0;

    for(int i=0; i<s.length(); i++){

      char ch = s.charAt(i);

      if(map.containsKey(ch)){
        start = Math.max(map.get(ch), start);
      }

      result = Math.max(result, (i-start+1));
      map.put(ch, i+1);
    }
    return result;
  }
}
