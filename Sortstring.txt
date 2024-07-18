import java.util.*;
//Solution using a HashMap
class Solution {
    //Tc: O(m+n) Sc: O(n)
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0 ; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < order.length(); i++)
        {
            char ch = order.charAt(i);
            if(map.containsKey(ch))
            {
                int cnt = map.get(ch);
                while(cnt > 0)
                {
                    res.append(ch);
                    cnt--;
                }
                map.remove(ch);
            }
        }
        for(char k : map.keySet())
        {
            int cnt = map.get(k);
            while(cnt > 0)
                {
                    res.append(k);
                    cnt--;
                }
        }
        return res.toString();

    }
}




/* 
import java.util.*;
//Solution using 2 ArrayLists
class Solution {
    public String customSortString(String order, String s) {
        //Tc: O(m*n) where m = length of order and n = length of string
        //Sc: O(n) where n is length of string
        List<Character> orderedList = new ArrayList<>();
        List<Character> remainingList = new ArrayList<>();

        for (char c : s.toCharArray()) {
            remainingList.add(c);
        }
        for (char ch : order.toCharArray()) {
            for (int j = 0; j < remainingList.size(); j++) {
                if (remainingList.get(j) == ch) {
                    orderedList.add(ch);
                    remainingList.remove(j);
                    j--; 
                }
            }
        }

        orderedList.addAll(remainingList);

        StringBuilder result = new StringBuilder();
        for (char c : orderedList) {
            result.append(c);
        }

        return result.toString();
    }
}
*/