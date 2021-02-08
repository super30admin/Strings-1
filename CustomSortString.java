// Time Complexity : O(s+t), s, t is length of the two strings S, T
// Space Complexity : O(s+t), space used for HashSet and HashMap
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Notes : Create a HashSet of all characters in S. Parse the characters in T and if they are present in the HashSet, add it to the HashMap along with their frequency of occurences. To maintain the order, iterate through S and get the frequencies of the characters and append accordingly to build the result string.

public class CustomSortString {
    public String customSortString(String S, String T) {
        
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < S.length(); i++){
            set.add(S.charAt(i));
        }
        
        HashMap<Character, Integer> map= new HashMap<>(); 
        StringBuilder rest = new StringBuilder("");
        for(int i = 0; i < T.length(); i++){
            char curr = T.charAt(i);
            if(set.contains(curr)){
                map.put(curr, map.getOrDefault(curr, 0) + 1);
            } else {
                rest.append(curr);
            }
        }
        
        StringBuilder result = new StringBuilder("");
        for(int i = 0; i < S.length(); i++){
            char curr = S.charAt(i);
            
            if(map.get(curr) != null){
                for(int j = 0; j < map.get(curr); j++){
                    result.append(curr);
                }
            }
        }
        
        result.append(rest);
        
        return result.toString();
    }
}
