/*
Time complexity : O(M+N)where M is the length of string S and N is the length of string T
Space complexity: O(N) length of string T as I would be inserting chars from String T in the map.
*/
class Solution {
   public String customSortString(String S, String T) {
       //edge case
        if(S.length() == 0 || T.length() == 0) 
            return T;
       
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer>map = new HashMap<>();
       
        // example S= "kqep", T="pekeq"
        //Inserting all the characters of String T into hashmap with their count.
        for(int i = 0; i < T.length(); i++)
            map.put(T.charAt(i) , map.getOrDefault(T.charAt(i), 0)+1); //map = p-1, e-2, k-1, q-1 
       
       //I want to sort characters in T in the order they appear in S
       //so I would be iterating over String S and if the character in S is present in map then I would be adding
       //the character into result string that many number of times it appears in T(count)
        for(int i = 0; i < S.length(); i++){
            while(map.containsKey(S.charAt(i)) && map.get(S.charAt(i)) > 0){
                sb.append(S.charAt(i));
                map.put(S.charAt(i), map.get(S.charAt(i))-1);
            }
        }
       //after adding characters of T which are present in S in the order of S, remaining characters of T 
       //I would be inserting at the end of result string. (can insert anywhere)
        for(char c: map.keySet()){
            while(map.get(c) > 0){
                sb.append(c);
                map.put(c, map.get(c)-1);
            }
        }
        return sb.toString();
    }
}
