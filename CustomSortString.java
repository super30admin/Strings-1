import java.util.*;

public class CustomSortString {
    public String customSortString(String S, String T) {
        if(S.length() == 0 || S == null)
            return T;
        // Creating map that contains the count of each character in string T
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<T.length(); i++){
            if(!map.containsKey(T.charAt(i))){
                map.put(T.charAt(i), 0);
            }
            map.put(T.charAt(i), map.get(T.charAt(i))+1);
        }
        String res = "";
        // Iterating through S and checking if my map contains the character if yes then repeat the character and add to string
        for(int i=0; i<S.length(); i++){
            if(T.contains(Character.toString(S.charAt(i)))){
                String temp = Character.toString(S.charAt(i));
                res += temp.repeat(map.get(S.charAt(i)));
            }        
        }
        // Now, checking for the characters that are not in the result string but they are in string T
        for(int i=0; i<T.length(); i++){
            if(!res.contains(Character.toString(T.charAt(i)))){
                String temp = Character.toString(T.charAt(i));
                res += temp.repeat(map.get(T.charAt(i)));      
            }
        }
        return res;   
    }
}