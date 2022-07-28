// Time Complexity : O(n+m) n and m are the length of string and the order;
// Space Complexity : O(n+m) Space for hashmap and the stringbuilder
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

import java.util.*;

class CustomSort {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        StringBuilder result = new StringBuilder();
        for(int j=0;j<order.length();j++){
            if(map.containsKey(order.charAt(j))){
                int cnt = map.get(order.charAt(j));
                for(int k=0;k<cnt;k++){
                    result.append(order.charAt(j));
                }
                map.remove(order.charAt(j));
            }
        }
        for(Map.Entry<Character, Integer> mp : map.entrySet()){
            int cnt = mp.getValue();
            for(int k=0;k<cnt;k++){
                result.append(mp.getKey());
            }
        }
        return result.toString();
    }


    public static void main(String [] args){
        CustomSort cs = new CustomSort();
        System.out.println(cs.customSortString("cba", "abcd"));
    }
}