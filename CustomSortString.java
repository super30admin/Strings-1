/**
 * Time Complexity : O(len(t)+len(s))
 * Space Complexity : O(len(t))
 */
import java.util.HashMap;
import java.util.Map;

public class CustomSortString {
    public String customSortString(String S, String T) {
        if(T.length() == 0 || T.length() == 0 ) return "";
        HashMap<Character,Integer> hm = new HashMap<>();

        for(char c : T.toCharArray())
        {
            hm.put(c,hm.getOrDefault(c,0)+1);
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < S.length()  ; i++)
        {
            char c = S.charAt(i);
            if(hm.containsKey(c))
            {
                for(int j = 0; j < hm.get(c);j++)
                {
                    sb.append(c);
                }
                hm.remove(c);
            }
        }

        for(Map.Entry<Character,Integer> entry : hm.entrySet())
        {
            char c = entry.getKey();
            for(int i = 0 ; i < hm.get(c) ; i++)
            {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}