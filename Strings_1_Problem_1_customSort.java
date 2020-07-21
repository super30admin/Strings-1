import java.util.HashMap;
import java.util.Map;

//Time Complexity : O(n) ( n = length of t + length of s )
//Space Complexity : O(n) (n = length of t string)
//Runs successfully on leetcode
//No problem

//Here we will be storing all the characters of T string and its frequency into the hashmap
//We will traverse through string s, if certain character exists, we will add that to our string with frequency
//In the end, we'll add remaining characters of t which are not in s



public class Strings_1_Problem_1_customSort {
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
