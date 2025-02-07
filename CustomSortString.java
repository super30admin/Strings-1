//soln1: have a hashtable -> with the values set to true
//create a frequency map for string s
//then iterate through the order string
//and add the remaining values to the rest of the string
//tc: O(S)
//sc: O(S)
//just need to get the hang of string manipulation functions, rest is okay
//i did not know freqmap.keyset for remaining characters, that's where i got stuck

class Solution {

  public String customSortString(String order, String s) {
    HashMap<Character, Integer> freqMap = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0) + 1);
    }

    int k = order.length();
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < k; i++) {
      char letter = order.charAt(i);
      while (freqMap.getOrDefault(order.charAt(i), 0) > 0) {
        result.append(letter);
        freqMap.put(letter, freqMap.get(letter) - 1);
      }
    }

    //iterate the remaining keyset
    for (char letter : freqMap.keySet()) {
      int count = freqMap.get(letter);
      while (count > 0) {
        result.append(letter);
        count--;
      }
    }

    return result.toString();
  }
}
