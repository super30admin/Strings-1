//Problem : 93 - Custom Sort String
//TC: Max(O(T)+O(S)) 
//SC: O(T) for string builder , if we think about hash map then O(1) because of 26 characters only

/*Steps
  Problem : String s is given in a sorted order and we have to mage String T in the same order as S. Suppose in S, if 'b' comes after 'c', then in String T 'b' should come after 'c'.

  Bruteforce : O(Exponential) : Generate combinations of String T and then check with the String S.

  Optimal : Just Store frequency of String T in the hash map, then iterate over the String S. While iterating over String S put the specific characters number according to their frequency and if their frequency becomes 0 remove them from the map. Once iteration over the S is completed just append remaining map characters to them.

*/
import java.util.*;
class Solution {
    public String customSortString(String S, String T) {
        
        StringBuilder sb = new StringBuilder();
        
        if(S==null || T==null || S.length()==0 || T.length()==0) return sb.toString();
        
        //TC: Max(O(T)+O(S)) | SC:O(T) for string builder , if we think about hash map then O(1) because of 26 characters only 
        Map<Character,Integer> freqMap = new HashMap<>();
        
        //TC:O(T), T is T length
        for(int i=0;i<T.length();i++){
            char ch = T.charAt(i);
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
        }
        
        
        //TC:O(S), S is S length
        for(int i=0;i<S.length();i++){
            char ch = S.charAt(i);
            if(freqMap.containsKey(ch)){
                int freq = freqMap.get(ch);
                while(freq>0){
                    sb.append(ch);
                    freq--;
                }
               freqMap.remove(ch);    
            }
        }
        
        for(char key:freqMap.keySet()){
             
            int freq = freqMap.get(key);
            while(freq>0){
                sb.append(key);
                freq--;
            }
        }
        
        return sb.toString();
    }
}