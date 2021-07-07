/*
Author: Akhilesh Borgaonkar
Problem: LC 791. Custom Sort String (Strings-1)
Approach: Using hashmap here to keep a track of frequency of characters appearing in T string and then iterating over the S string to append the 
    characters as much as frequency appearing in T and then append the rest of the characters in T sequentially at the end of String builder.
Time Complexity: O(n) where n is length of string T.
Space complexity: O(1) coz worst you will store 256 characters in HashMap.
LC verified.
*/

class Solution {
    public String customSortString(String S, String T) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<T.length(); i++){                        //add T characters and their frequencies of occurence in hashmap
            if(map.containsKey(T.charAt(i))){
                map.put(T.charAt(i), map.get(T.charAt(i))+1);
            } else 
                map.put(T.charAt(i), 1);
        }
                
        for(int j=0; j<S.length(); j++){            //iterating over S and appending to buffer as many frequency times as it appears in string T
            if(map.containsKey(S.charAt(j))){
                int sfreq = map.get(S.charAt(j));
                for(int k=0; k<sfreq; k++)
                    sb.append(S.charAt(j));
                map.remove(S.charAt(j));
            }
        }
                
        for(char c : map.keySet()){         //append the remaining characters from string T which are now in hashmap
            int tfreq = map.get(c);
            for(int l=0; l<tfreq; l++)
                sb.append(c);
        }
        return sb.toString();
    }
}