//Time Complexity:O(length of T)
//Space Complexity:O(length of T) for hashmap
/*Approach 
-Going though the T string and storing its character with count in map
-In result storing characters as occurring in S string (number of times as in the map)
-remaining  characters can be given in any sequence because they are not in S string, so taking remaining
characters and appending in result
*/
import java.util.HashMap;

public class CustomSortString {
    public String customSortString(String S, String T) {
        StringBuilder result = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : T.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        for(int i = 0; i < S.length() ; i++){
            char c = S.charAt(i);
            if(map.containsKey(c)){
                int count = map.get(c);
                while(count > 0){
                    result.append(c);
                    count--;
                }
                map.remove(c);
            }
        }
        for(char c : map.keySet()){
            int count = map.get(c);
                while(count > 0){
                    result.append(c);
                    count--;
                }
        }
        return result.toString();
    }
    public static void main(String args[]){
        CustomSortString obj = new CustomSortString();
        System.out.println(obj.customSortString("cba", "ajkbcbtsoaacbmb"));
    }

}