package s30Coding;
import java.util.*;

//Time Complexity :- Linear O(n) where n is length of the string
//Space Complexity :- O(1) 26 as the map would store at most 26 characters.
//LeetCode :- Yes
public class CustomSortString {
	public String customSortString(String S, String T) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < T.length(); i++){
            Character c = T.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        for(int i = 0; i < S.length(); i++){
            Character c = S.charAt(i);
            if(map.containsKey(c)){
                int cnt = map.get(c);
                while( cnt > 0){
                    sb.append(c);
                    cnt--;
                }
                map.remove(c);
            }
        }
        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            int cnt = entry.getValue();
            Character c= entry.getKey();
            while(cnt > 0){
                sb.append(c);
                cnt--;
            }
            
        }
        return sb.toString();
    }
}
