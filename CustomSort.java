// O(n + m) time: n length of order, m length of s, combined time it takes to iterate through both
// O(m) space: final answer has same length as string s

class Solution {
    public String customSortString(String order, String s) {
        // create a count array that tracks number of occurrences of each char in string s
        // count[0] = no of occurrences for char a, and so on
        int[] count = new int[26];
        for (char c : s.toCharArray()){
            count[c - 'a']++;
        }
        
        StringBuilder answer = new StringBuilder(); // use StringBuilder to join word
        
        for (char c : order.toCharArray()){
            for (int i = 0; i < count[c - 'a']; i++){
                answer.append(c);
            }
            count[c - 'a'] = 0; // no longer need to write char into our answer anymore
        }
        
        // all remaining chars
        for (char c = 'a'; c <= 'z'; c++){
            for (int i = 0; i < count[c - 'a']; i++){
                answer.append(c);
            }
        }
        
        return answer.toString();
    }
}