/*
TC: O(M+N) M - length of S, N - length of T
SC: O(N) - N - length of T

1. Keep count of each character in T in a map.
2. Traverse the string S, append the count of character c obtained from map in result string. Remove entry of c from the map.
3. For remaining characters not present in S but present in T, traverse the map and append. 

*/

import java.util.*;

public class CustomSort{
    public String customSort(String S, String T){
        if(S == null || S.length() == 0) return T;

        HashMap<Character, List<Integer>> map = new HashMap<>();
        //creation of map
        for(int i = 0; i < T.length(); i++){
            char c = T.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, new ArrayList<>());
            }
            map.get(c).add(i);
        }
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < S.length(); i++ ){
            char c = S.charAt(i);
            if(map.containsKey(c)){
                List<Integer> list  = map.get(c);
                map.remove(c);
                for(int idx : list){
                    sb.append(T.charAt(idx));
                }
            }
        }

        for(Map.Entry<Character, List<Integer>> entry : map.entrySet()){
            List<Integer> list = entry.getValue();
            for(int idx : list){
                sb.append(T.charAt(idx));
            }
        }

        return sb.toString();
    }

    public String customSortString(String S, String T) {
        if(S == null || S.length() == 0) return  T;
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < T.length(); i++){
            char c = T.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(char c : S.toCharArray()){
            if(map.containsKey(c)){
                int count = map.get(c);
                while(count > 0){
                    sb.append(c);
                    count--;
                }
                map.remove(c);
            }
        }
        
        for(Map.Entry<Character, Integer> entry: map.entrySet()){
            char c = entry.getKey();
            int count = entry.getValue();
            while(count > 0){
                sb.append(c);
                count--;
            }
        }
        
        return sb.toString();
    }

    public static void main(String[] args){
        String S = "cba";
        String T = "aabbcddeeffg";
        CustomSort sort = new CustomSort();

        System.out.println(sort.customSort(S, T));
        System.out.println(sort.customSortString(S, T));


    }
}