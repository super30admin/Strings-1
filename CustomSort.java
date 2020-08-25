/*
  Time : O(m+n) m = length of S, n = length of T.
  Space: O(1) ony storing max 26 chars in map.
  Run on LeetCode : yes
*/
class Solution {
    public String customSortString(String S, String T) {

        StringBuilder str = new StringBuilder();
        HashMap<Character, Integer> hmp = new HashMap<>();

        // create hashmap. O(n)
        for(int i = 0 ; i < T.length();i++){
            int val = hmp.getOrDefault(T.charAt(i), 0);
            hmp.put(T.charAt(i), val+1);
        }

        //walk over S and create str. O(n)
        for(int i = 0 ; i < S.length();i++){
            char s = S.charAt(i);
            int val = hmp.getOrDefault(s, 0);
            while(val > 0){
                str.append(s);
                val--;
            }
            hmp.remove(s);
        }

        // now add rest of the remaning letter in T to str, O(n)
        for(Map.Entry<Character, Integer> set : hmp.entrySet()){
            char ch = set.getKey();
            int val = set.getValue();

            while(val > 0){
                str.append(ch);
                val--;
            }
        }
        return str.toString();
    }
}
